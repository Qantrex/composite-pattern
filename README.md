# Mathematische Ausdrücke

Ausdrücke in Mathematik und Programmiersprachen sind uns allen bekannt. Zum Beispiel hat der Ausdruck 2 + 3 * 2 den Wert 8 oder der Ausdruck sin(0) den Wert 0. Der Wert eines Ausdrucks 2 * x hängt davon ab, welchen Wert die Variable x hat.

In dieser Aufgabe sollen solche Ausdrücke mit Hilfe des Composite-Patterns implementiert werden. Dabei sollen zumindest folgende Arten von Ausdrücken unterstützt werden:

    Zahlen: z.B. 2, 3.1415
    Grundrechnungsarten: -a, a + b, a - b, a * b, a / b, a ^ b
    Minimum und Maximum beliebig vieler Ausdrücke: min(a), min(a, b), max(a, b, c)

Wobei a, b und c jeweils wiederum beliebige Ausdrücke sein können.

Benutze für diese Aufgabe (gemeinsam mit dem EK-Teil) ein Git Repository und verwende folgenden GitHub Classroom Link:

https://classroom.github.com/a/DhGuIx-z
GKÜ

Erstelle bevor du zu programmieren beginnst einen Entwurf (UML-Klassendiagramm) nach dem Composite-Muster, das diese Funktionalität umsetzt. Es soll für einen Ausdruck sowohl möglich sein, eine String-Darstellung (wie z.B. "(2 + 2)") als auch das Ergebnis (z.B. 4) zu erhalten. Der Text-String sowie das Ergebnis sollen von den Composite-Klassen selbst zusammengesetzt werden, nicht durch Zugriff auf die einzelnen Teile von außen. Implementiere die entsprechenden Klassen in Java und teste die Funktion ausführlich mit einer main-Methode.

Im Git-Versionsverlauf muss nachvollziehbar sein, dass das UML-Diagramm zuerst erstellt wurde. Füge das UML-Klassendiagramm auch als Bilddatei (png/svg) in das Repo ein. Sollten sich während der Umsetzung zusätzliche Erfordernisse ergeben, kannst du das UML-Diagramm später aktualisieren, aber die erste Version muss schon am Anfang entstanden sein.
GKV

Vermeide Code-Duplication: welche verschiedenen komplexen Ausdrücke haben gemeinsame Strukturen? Setze deinen Code so um, dass diese gemeinsamen Teile nicht mehrmals implementiert werden müssen.

Statt den Code in der Main-Methode zu testen und die Ergebnisse immer manuell überprüfen zu müssen, sind automatisierte Tests mit JUnit natürlich viel besser geeignet. Setze deine ausführlichen Tests auf diese Weise um. Gib dir Mühe, Rand- und Fehlerfälle zu identifizieren und sinnvoll zu testen (Testprotokoll ist aber keines notwendig).
Abgabe

Trage einen direkten Github-Link auf den letzten Commit in deinem Repository als Textabgabe ein. Dieser Link müsste also so aussehen: https://​github.com/TGM-HIT/sew8-2526-expressions-<github-username>/commit/<commit-id>. Ein Link auf das Repo (statt auf den Commit) weist nicht den Abgabezeitpunkt nach und ist deshalb nicht ausreichend.

Deine Abgabe muss den gesamten Sourcecode und das UML-Klassendiagramm beinhalten. Die Beurteilung erfolgt in einem Abgabegespräch.
