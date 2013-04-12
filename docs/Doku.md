# Web-basierte Anwendungen 2 - Verteilte Systeme
## Dokumentation zur Phase 1
### Aufgabe 1
Erklären Sie kurz die Begriffe Wohlgeformtheit, Validität und Namespaces im Bezug auf XML und XML-Schema.

**Wohlgeformt** ist ein Dokument, welches alle XML Regeln einhält.  
Dazu zählen zum Beispiel:
  
* die XML-Deklaration muss vorhanden sein
* ein Wurzel Element muss alle folgenden Elemente umschließen
* und weitere

**Validität** beschreibt ein Dokument, welches wohlgeformt ist, auf eine Grammatik verweist (eine DTD oder ein XML Schema) und deren Format einhält.  
**Namespaces** helfen ein Dokument eindeutig zu identifizieren und mehrerer XML-Sprachen zu mischen.

Quellen:
Vorlesung 08.04.
http://de.selfhtml.org/xml/regeln/begriffe.htm

### Aufgabe 2
**a)** Erzeugen Sie ein XML-Dokument, dass die Daten des folgenden Formulars vollständig erfasst: http://www.gm.fh-koeln.de/~vsch/anmeldung/gruppenanmeldung.html

*siehe src Ordner*

Als Wurzelelement dient "registration". Jeder Registration umfasst einen oder mehrere Personen.
Die Personen haben ein Attribut "role" welches identifiziert ob sie Gruppenführer oder normales Mitglied sind.
Alternativ hätten verschiedene Elemente für "leader" und "member" definiert werden können.
Für die restlichen Daten, zB Vor- und Nachname wurden simple Unterelemente in "person" definiert.
Da es zu jeder Gruppe nur eine Anmerkung gibt, wurde ein "note" Element unter "registration" hinzugefügt.
Hätte man in "leader" und "member" Elemente unterteilt, könnte man das "note" Element als Unterelement des "leader" definieren.

**b)** Erzeugen Sie ein JSON-Dokument, dass zu ihrem XML-Dokument äquivalent ist.

*siehe src Ordner*

In einem äquivalenten JSON-Dokument war keine Änderung gegenüber der Struktur des XML Dokuments nötig.

### Aufgabe 3
**a)** Gegeben ist folgendes Rezept: http://www.chefkoch.de/rezepte/24641006006067/Lenchen-s-Schokoladenkuchen.html  
Entwickeln Sie ein XML-Dokument, in dem die Daten des Rezeptes abgebildet werden. Achten Sie darauf, dass das Dokument semantisch möglichst reichhaltig ist.

*siehe src Ordner*

Zunächst war es wichtig verschiedene Elemente zu gruppieren. Als Wurzelelement bot sich "recipe".
Zu "recipe" gehören simple Elemente wie "title", "workingtime", "difficulty" und "kcal".
Alternativ hätte diese Werte als Attribute in "recipe" abgebildet werden können.
Da es aber bei diesen Elementen zu komplexen Texten kommen kann, wenig Sinn machen.  
Des weiteren hat das "recipe" "ingredients" (Zutaten), die sich in einzelne "ingredient" Elemente unterteilen.
Jede "ingredient" hat zwei Attribute, "amount" und "unit". "ingredient" hätte die Attribute auch als Unterelement haben können.
Aufgrund ihrer Primitivität bieten sich die Attribute an.  
Außerdem verfügt jedes Rezept über eine schrittweise Vorbereitung.
Einzelne "step" wurden im Element "preperation" zusammengefasst.
Zur Identifizierung der Schritt Reihenfolge wurde ein "id" Attribute einem Unterelement vorgezogen.  
Eine ähnliche Struktur liegt bei den Kommentaren vor. Zur Identifizierung wird ein "id" Attribute benutzt.

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
* Anzahl und Ausführlichkeit der Zubereitungsschritte
* Anzahl Kommentare (keine, eins oder mehr)

**c)** Arbeiten Sie die Kriterien heraus, die für die Entwicklung einer XML-Schema-Datei beachtet werden müssen. Die Schema-Datei soll die Struktur für eine XML-Datei definieren, in der mehrere unterschiedliche Rezepte gespeichert werden können.  
Ziel ist es, dass das XML-Schema möglichst restriktiv ist, so dass in der XML-Datei möglichst semantisch sinnvolle Daten bezüglich der Rezepte gespeichert werden können. Ziehen Sie beim Aufstellen der Kriterien u.A. folgende Fragestellungen in Betracht:

* Welche Daten müssen in simple und welche in complex-types abgebildet werden?

  Als simple-types können die Elemente für Titel, Arbeitszeit, Schwierigkeit und Brennwert abgebildet werden.  
  Alles andere muss Aufgrund von Referenzen auf Attribute oder Elemente also complex abgebildet werden.

* Für welche Daten ist die Abbildung in Attributen sinnvoller?

  Für IDs, Mengen Angaben und Maßeinheiten ist die Abbildung als Attribut auf Grund ihrer Primitivität sinnvoller.

* Welche Datentypen müssen für die Elemente definiert werden?

  Als Datentyp muss für fast alle Elemente "string" benutzt werden. Mit einigen Außnahmen:
  
  * IDs bekommmen den Datentyp "id"
  * Brennwert und Anzahl der Zutat den Typ "integer"  
  
* Welche Restriktionen müssen definiert werden?

  Zum einen müssen IDs vorhanden sein und zum anderen muss es mindestens eine Zutat und einen Zubereitungsschritt geben.
  
**d)** Erstellen Sie nun ein XML-Schema auf Basis ihrer zuvor definierten Kriterien. Generieren Sie nun auf Basis des Schemas eine XML-Datei und füllen Sie diese mit zwei unterschiedlichen und validen Datensätzen. 

*siehe src Ordner*

### Aufgabe 4

In dieser Aufgabe entwickeln Sie mit Hilfe des JAXB Frameworks ein Java-Programm, welches die XML-Datei aus der vorigen Aufgabe einlesen, modifizieren und ausgeben kann.
  
*siehe src Ordner*

### Aufgabe 5

Diskutieren Sie, warum es sinnvoll ist Daten in Formaten wie XML oder JSON zu speichern. Stellen Sie außerdem die beiden Formate gegenüber und erläutern Sie kurz deren Vor- und Nachteile.

Beide Formate eigenen sich für die strukturierte Speicherung von Daten. Sowohl XML als auch JSON können sowohl gut von Machinen als auch von Menschen gelesen werden.  
XML kann im Gegensatz eigene Regeln in Form von DTD oder XML erstellen. Dies kann aber bei einem Datentransport zu Verlust führen.  
XML sollte deshalb als Auszeichnungssprache benutzt werden und JSON zum Datentransport.

