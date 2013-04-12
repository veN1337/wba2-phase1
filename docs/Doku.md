# Web-basierte Anwendungen 2 - Verteilte Systeme
## Dokumentation zur Phase 1
### Aufgabe 1
Erkl�ren Sie kurz die Begriffe Wohlgeformtheit, Validit�t und Namespaces im Bezug auf XML und XML-Schema.

**Wohlgeformt** ist ein Dokument, welches alle XML Regeln einh�lt.  
Dazu z�hlen zum Beispiel:
  
* die XML-Deklaration muss vorhanden sein
* ein Wurzel Element muss alle folgenden Elemente umschlie�en
* und weitere

**Validit�t** beschreibt ein Dokument, welches wohlgeformt ist, auf eine Grammatik verweist (eine DTD oder ein XML Schema) und deren Format einh�lt.  
**Namespaces** helfen ein Dokument eindeutig zu identifizieren und mehrerer XML-Sprachen zu mischen.

Quellen:
Vorlesung 08.04.
http://de.selfhtml.org/xml/regeln/begriffe.htm

### Aufgabe 2
**a)** Erzeugen Sie ein XML-Dokument, dass die Daten des folgenden Formulars vollst�ndig erfasst: http://www.gm.fh-koeln.de/~vsch/anmeldung/gruppenanmeldung.html

*siehe src Ordner*

Als Wurzelelement dient "registration". Jeder Registration umfasst einen oder mehrere Personen.
Die Personen haben ein Attribut "role" welches identifiziert ob sie Gruppenf�hrer oder normales Mitglied sind.
Alternativ h�tten verschiedene Elemente f�r "leader" und "member" definiert werden k�nnen.
F�r die restlichen Daten, zB Vor- und Nachname wurden simple Unterelemente in "person" definiert.
Da es zu jeder Gruppe nur eine Anmerkung gibt, wurde ein "note" Element unter "registration" hinzugef�gt.
H�tte man in "leader" und "member" Elemente unterteilt, k�nnte man das "note" Element als Unterelement des "leader" definieren.

**b)** Erzeugen Sie ein JSON-Dokument, dass zu ihrem XML-Dokument �quivalent ist.

*siehe src Ordner*

In einem �quivalenten JSON-Dokument war keine �nderung gegen�ber der Struktur des XML Dokuments n�tig.

### Aufgabe 3
**a)** Gegeben ist folgendes Rezept: http://www.chefkoch.de/rezepte/24641006006067/Lenchen-s-Schokoladenkuchen.html  
Entwickeln Sie ein XML-Dokument, in dem die Daten des Rezeptes abgebildet werden. Achten Sie darauf, dass das Dokument semantisch m�glichst reichhaltig ist.

*siehe src Ordner*

Zun�chst war es wichtig verschiedene Elemente zu gruppieren. Als Wurzelelement bot sich "recipe".
Zu "recipe" geh�ren simple Elemente wie "title", "workingtime", "difficulty" und "kcal".
Alternativ h�tte diese Werte als Attribute in "recipe" abgebildet werden k�nnen.
Da es aber bei diesen Elementen zu komplexen Texten kommen kann, wenig Sinn machen.  
Des weiteren hat das "recipe" "ingredients" (Zutaten), die sich in einzelne "ingredient" Elemente unterteilen.
Jede "ingredient" hat zwei Attribute, "amount" und "unit". "ingredient" h�tte die Attribute auch als Unterelement haben k�nnen.
Aufgrund ihrer Primitivit�t bieten sich die Attribute an.  
Au�erdem verf�gt jedes Rezept �ber eine schrittweise Vorbereitung.
Einzelne "step" wurden im Element "preperation" zusammengefasst.
Zur Identifizierung der Schritt Reihenfolge wurde ein "id" Attribute einem Unterelement vorgezogen.  
Eine �hnliche Struktur liegt bei den Kommentaren vor. Zur Identifizierung wird ein "id" Attribute benutzt.

**b)** Betrachten Sie nun andere Rezepte auf der Webseite http://www.chefkoch.de. Beschreiben Sie welche Gemeinsamkeiten die Rezepte hinsichtlich ihrer Daten haben und worin Sie sich unterscheiden.

Alle Rezepte auf Chefkoch haben gemeinsam:

* eine eindeutige Identifizierung
* einen Titel
* eine Zutatenliste
* Schritte zur Zubereitung
* Zubereitungszeit
* Schwierigkeit
* Brennwert (Angabe in kcal)

Unterscheiden sich aber in folgenden Bereichen:

* Anzahl und Arten der Zutaten
* Anzahl und Ausf�hrlichkeit der Zubereitungsschritte
* Anzahl Kommentare (keine, eins oder mehr)

**c)** Arbeiten Sie die Kriterien heraus, die f�r die Entwicklung einer XML-Schema-Datei beachtet werden m�ssen. Die Schema-Datei soll die Struktur f�r eine XML-Datei definieren, in der mehrere unterschiedliche Rezepte gespeichert werden k�nnen.  
Ziel ist es, dass das XML-Schema m�glichst restriktiv ist, so dass in der XML-Datei m�glichst semantisch sinnvolle Daten bez�glich der Rezepte gespeichert werden k�nnen. Ziehen Sie beim Aufstellen der Kriterien u.A. folgende Fragestellungen in Betracht:

* Welche Daten m�ssen in simple und welche in complex-types abgebildet werden?

  Als simple-types k�nnen die Elemente f�r Titel, Arbeitszeit, Schwierigkeit und Brennwert abgebildet werden.  
  Alles andere muss Aufgrund von Referenzen auf Attribute oder Elemente also complex abgebildet werden.

* F�r welche Daten ist die Abbildung in Attributen sinnvoller?

  F�r IDs, Mengen Angaben und Ma�einheiten ist die Abbildung als Attribut auf Grund ihrer Primitivit�t sinnvoller.

* Welche Datentypen m�ssen f�r die Elemente definiert werden?

  Als Datentyp muss f�r fast alle Elemente "string" benutzt werden. Mit einigen Au�nahmen:
  
  * IDs bekommmen den Datentyp "id"
  * Brennwert und Anzahl der Zutat den Typ "integer"  
  
* Welche Restriktionen m�ssen definiert werden?

  Zum einen m�ssen IDs vorhanden sein und zum anderen muss es mindestens eine Zutat und einen Zubereitungsschritt geben.
  
**d)** Erstellen Sie nun ein XML-Schema auf Basis ihrer zuvor definierten Kriterien. Generieren Sie nun auf Basis des Schemas eine XML-Datei und f�llen Sie diese mit zwei unterschiedlichen und validen Datens�tzen. 

*siehe src Ordner*

### Aufgabe 4

In dieser Aufgabe entwickeln Sie mit Hilfe des JAXB Frameworks ein Java-Programm, welches die XML-Datei aus der vorigen Aufgabe einlesen, modifizieren und ausgeben kann.
  
*siehe src Ordner*

### Aufgabe 5

Diskutieren Sie, warum es sinnvoll ist Daten in Formaten wie XML oder JSON zu speichern. Stellen Sie au�erdem die beiden Formate gegen�ber und erl�utern Sie kurz deren Vor- und Nachteile.

Beide Formate eigenen sich f�r die strukturierte Speicherung von Daten. Sowohl XML als auch JSON k�nnen sowohl gut von Machinen als auch von Menschen gelesen werden.  
XML kann im Gegensatz eigene Regeln in Form von DTD oder XML erstellen. Dies kann aber bei einem Datentransport zu Verlust f�hren.  
XML sollte deshalb als Auszeichnungssprache benutzt werden und JSON zum Datentransport.

