Tic Tec Toe demo application
=========================

This is a play! framework demo application, written during a 3 hour live coding session at the [Webstep](http://webstep.no) Tic Tec Toe arrangement 20th october 2011.
Check out the demo [here](http://demo.aabergs.net)

Veiledning
------------
Før du kjører "play run" kommandoen for første gang, må du kjøre "play dependencies" kommandoen.

Endringer
------------
Jeg har gjort et par endringer, i forhold til den originale kode.

- Jeg har rettet feilen med dropdown listen, hvor der velges språk. Den blev ved å hoppe tilbake på 'English'. Jeg hadde satt fnutter (') runt om play.i18n.Lang.get() metodekaldet. Derfor blev det behandlet som en tekststreng.
- Jeg har oversatt resten av applikasjonen.
- Jeg har tilføyet links til brukerlisten og 'secret stuff' siden, på forsiden.