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

El diseño del proyecto puede ser dividido en dos partes: los jugadores y las cartas. Partamos ahondando en el primero.

#### Jugadores:

Los jugadores en el programa son aquellos que se enfrentan en el juego de cartas. Como no se da una especificación de un jugador de otro, pero sí se mencionan las variables que estos poseen y los métodos que implementan, se optó por el uso de una interfaz (IPlayer) que describa todos los métodos y variables que todo jugador debe tener. Esto permite que, a futuro, los cambios que se realicen en las funcionalidades de los jugadores no se tengan que implementar a cada subjugador.

La interfaz de jugador se aplica sobre una clase jugador (Player), que modela el jugador del usuario, donde todas las variables y métodos quedan definidos de forma estándar según lo implementado en la interfaz. Tener distintas clases para cada tipo de jugador (actualmente solo tenemos el propio jugador) permite lograr una especificación en los aspectos que se diferencien entre unos y otros, permitiendo realizar cambios según las necesidades específicas de cada jugador. 

Por otro lado, cada jugador controla un mazo de cartas y una mano de cartas. Para una funcionalidad correcta, se decidió crear una estructura que modele el funcionamiento de ambos grupos de cartas, para así disminuir el nivel de complejidad de la clase Player. Para el diseño de esta estructura, se optó por una interfaz (ICardGroup) que define los parámetros y métodos de las cartas agrupadas. Luego, se crearon 2 clases (Deck y Hand) que extendieran a la interfaz, para poder así aplicar los métodos correspondientes al manejo de cartas para cada caso.

#### Cartas:

Las cartas son las herramientas que permiten llevar a cabo el juego. Éstas se utilizan en un tablero (aunque todavía no se ha implementado), donde cada zona del tablero está especificada para un tipo particular de carta. Los tipos de cartas son: las cartas de combate y las cartas de clima. Las cartas de combate se dividen en cartas de combate cuerpo a cuerpo, a rango y de asedio, mientras que las cartas de clima se especifican dependiendo del tipo de clima (en esta versión del proyecto solamente se tomaron en consideración 2 climas).

Teniendo esto claro, se decidió crear una interfaz (ICard) que definiera los métodos y variables que toda carta debía tener, describiendo así un comportamiento general de éstas. El uso de la interfaz, a su vez, permite la instanciación de la carta como tipo global, lo que permite definir ciertas variables, como el mazo y la mano de la clase Player, por ejemplo.

Para lograr una mayor especificación en cada subtipo de carta, se crearon dos interfaces (IUnitCard e IWeatherCard), donde cada una de éstas define los métodos y variables que son propios de cada tipo de carta, respectivamente. Al igual que con la interfaz anterior, esto permite definir ciertas variables a futuro (tablero) para lograr un diseño y funcionalidad correctos.

Para cada interfaz específica se creó una clase abstracta respectiva que define los métodos propuestos en las interfaces. Esta clase será usada por otras subclases más específicas a modo de punto de apoyo. Luego, tal como se mencionó, se crearon clases que heredan de ambas clases abstractas. Estas clases especifican los tipos de cartas antes mencionados y son ocupadas como clases instanciadas para el uso en el juego.

Dentro de las clases de cartas ya definidas existían variables de tipo específico, siendo éstas el tipo de habilidad especial (para las cartas de unidad) y el tipo de clima (para las cartas de clima). Por lo tanto, se creó una interfaz para cada una (ISpecialAbility e IWeatherType) con el fin de modelarlas de forma particular, pero a la vez manteniendo una funcionalidad en común para cada subclase. A partir de estas dos interfaces, se crearon clases que extendían a éstas. Estas clases son los parámetros específicos de cada carta en el juego.
