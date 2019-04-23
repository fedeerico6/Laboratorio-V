1_ Las diferencias entre Runnable y Thread son:
- Runnable es una interfaz, mientras que Thread es una clase.
- Si extendes de Thread no podes extender de otra clase, ya que Java no permite herencia multiple. Mientras que Runnable
es una interfaz y en Java se puede implementar todas las intefaces que uno desee.
- Cuando se extiende la clase Thread, cada subproceso crea un objeto único y se asocia con el. Cuando se implementa Runnable, comparte el mismo objeto con varios subprocesos.
- Thread ya tiene los metodos implementados, mientras que cuando se implemente Runnable se tiene de codificar el metodo run().
- Runnable es sólo una interfaz que necesita para instanciar un hilo para contenerlo. Mientras que el hilo contiene ya la capacidad de generar un hilo.
- Al extender la clase Thread, cada subproceso crea un objeto único y se asocia con él. Cuando implementa Runnable, comparte el mismo objeto con varios subprocesos.

2_ ¿Cual es el ciclo de vida de un Thread?
Un hilo puede estar en cuatro estados:
- Inicial: antes de ejecutar el metodo start(). En realidad todavia no es un hilo.
- En ejecucion: tras ejecutar start() y durante el metodo run().
- Bloqueado: 
	* En un candado (synchronized).
	* Durmiendo: Thread.sleep(milisegundos).
- Finalizado. 

3_ Start(): Este metodo se encarga de iniciar un nuevo hilo. Hace que este subproceso comience a ejecutarse, la Máquina Virtual de Java llama al método de ejecución de este subproceso. 
El resultado es que dos subprocesos se ejecutan simultáneamente: el subproceso actual (que regresa de la llamada a el método de inicio) y el otro hilo (que ejecuta su método de ejecución).

Sleep(): El método se puede usar para pausar la ejecución del subproceso actual durante milisegundos durante un tiempo especificado. El valor del argumento por milisegundos no puede ser negativo, 
de lo contrario, se lanza IllegalArgumentException.

Yield(): Hace que el objeto del subproceso que se ejecuta actualmente se detenga temporalmente y permita que se ejecuten otros subprocesos.

Join(): Se puede utilizar para pausar la ejecución del subproceso actual hasta que el subproceso especificado esté muerto.