# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---
El siguiente proyecto desarrollado en Scala implementa un sistema de juegos de cartas inspirado en el juego de cartas Gwent. Como en el juego original, este se compone de diferentes cartas que determinan las acciones y consecuencias en el juego, y de un jugador que es el que está a cargo del manejo de las cartas. A continuación, se hablará sobre el diseño planteado para este, explicando el porqué de la elección de este.

## Diseño: 

El diseño del proyecto puede ser dividido en tres principales partes: los jugadores, las cartas y el tablero. Partamos ahondando en el primero.

#### Jugadores:

Los jugadores en el programa son aquellos que se enfrentan en el juego de cartas. Como no se da una especificación de un jugador de otro, pero sí se mencionan las variables que estos poseen y los métodos que implementan, se optó por el uso de una interfaz (IPlayer) que describa todos los métodos y variables que todo jugador debe tener. Esto permite que, a futuro, los cambios que se realicen en las funcionalidades de los jugadores no se tengan que implementar a cada subjugador.

La interfaz de jugador se aplica sobre una clase jugador (Player), que modela el jugador del usuario, donde todas las variables y métodos quedan definidos de forma estándar según lo implementado en la interfaz. Tener distintas clases para cada tipo de jugador (actualmente solo tenemos el propio jugador) permite lograr una especificación en los aspectos que se diferencien entre unos y otros, permitiendo realizar cambios según las necesidades específicas de cada jugador. 

Por otro lado, cada jugador controla un mazo de cartas y una mano de cartas. Para una funcionalidad correcta, se decidió crear una estructura que modele el funcionamiento de ambos grupos de cartas, para así disminuir el nivel de complejidad de la clase Player. Para el diseño de esta estructura, se optó por una interfaz (ICardGroup) que define los parámetros y métodos de las cartas agrupadas. Luego, se crearon 2 clases (Deck y Hand) que extendieran a la interfaz, para poder así aplicar los métodos correspondientes al manejo de cartas para cada caso.

#### Cartas:

Las cartas son las herramientas que permiten llevar a cabo el juego. Éstas se utilizan en un tablero (que sera explicado mas adelante), donde cada zona del tablero está especificada para un tipo particular de carta. Los tipos de cartas son: las cartas de combate y las cartas de clima. Las cartas de combate se dividen en cartas de combate cuerpo a cuerpo, a rango y de asedio, mientras que las cartas de clima se especifican dependiendo del tipo de clima.

Teniendo esto claro, se decidió crear una interfaz (ICard) que definiera los métodos y variables que toda carta debía tener, describiendo así un comportamiento general de éstas. El uso de la interfaz, a su vez, permite la instanciación de la carta como tipo global, lo que permite definir ciertas variables, como el mazo y la mano de la clase Player, por ejemplo.

Para lograr una mayor especificación en cada subtipo de carta, se crearon dos interfaces (IUnitCard e IWeatherCard), donde cada una de éstas define los métodos y variables que son propios de cada tipo de carta, respectivamente. Al igual que con la interfaz anterior, esto permite definir ciertas variables a futuro (tablero) para lograr un diseño y funcionalidad correctos.

Para cada interfaz específica se creó una clase abstracta respectiva que define los métodos propuestos en las interfaces. Esta clase será usada por otras subclases más específicas a modo de punto de apoyo. Luego, tal como se mencionó, se crearon clases que heredan de ambas clases abstractas. Estas clases especifican los tipos de cartas antes mencionados y son ocupadas como clases instanciadas para el uso en el juego.

Dentro de las clases de cartas ya definidas existían variables de tipo específico, siendo éstas el tipo de habilidad especial (para las cartas de unidad) y el tipo de clima (para las cartas de clima). Por lo tanto, se creó una interfaz para cada una (ISpecialAbility e IWeatherType) con el fin de modelarlas de forma particular, pero a la vez manteniendo una funcionalidad en común para cada subclase. A partir de estas dos interfaces, se crearon clases que extendían a éstas. Estas clases son los parámetros específicos de cada carta en el juego.

### Tablero:

El tablero es la unión de las dos secciones anteriores, donde los jugadores pueden jugar sus cartas en zonas determinadas para cada jugador.

El diseño del tablero se divide en 2 zonas de cartas de unidad, donde cada una corresponde a un jugador, y 1 zona de cartas de clima, que es compartida entre los jugadores en el juego.

Cada zona de cartas de unidad está compuesta por el jugador a cargo y por 3 secciones donde se pueden colocar cartas del tipo correspondiente a la sección.

Para lograr el diseño, se parte de la base de una interfaz, IBoardSection, que representará todos los tipos de secciones, siendo estos correspondientes a los tipos de las cartas.

A partir de esta interfaz, se crearon 4 clases que extienden de ella, siendo estas CloseCombatSection, WeatherSection, RangedSection y SiegeSection, donde cada una recibe solamente el tipo de carta que indica su propio nombre.

Teniendo ya diseñadas las secciones, se creó la clase HalfBoard para representar cada mitad del tablero, que, tal como se mencionó anteriormente, contiene las tres secciones de cartas de unidad y el jugador correspondiente a esas secciones.

Finalmente, se creó la clase Board, la cual representa el tablero completo. Está compuesta por dos HalfBoard y una zona de cartas de clima. Es en esta clase donde se llevan a cabo las acciones del juego, como jugar una carta o limpiar el tablero.
### Funcionamiento

Finalmente, hay que mencionar el funcionamiento interno para las acciones descritas hasta ahora en el programa, siendo estas limpiar el tablero y jugar una carta. La primera de estas es muy simple, solamente se trata de un método de la misma estructura usada para guardar las cartas, que simplemente limpia la lista que las contiene. Ahondaremos con más detalle en la segunda acción.

Para llevar a cabo el funcionamiento de jugar una carta y que cada carta vaya exactamente a la sección correspondiente, se utilizó el método de diseño Double Dispatch. A continuación, se dará una explicación más detallada del funcionamiento de este en el programa.

Al ejecutar el método para jugar una carta, se envía una señal a la clase correspondiente de la carta que debe ser jugada. La carta recibe como parámetro el tablero donde debe ser jugada, parámetro que se utiliza en el método de la carta para ser jugada. Este método posee internamente una especificación para cada subtipo de carta, donde respectivamente cada carta se agrega a la sección correspondiente del tablero.