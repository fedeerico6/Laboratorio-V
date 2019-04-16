1_ Maven es un framework de administración de proyectos. Una herramienta que automatiza el proceso de construcción 
de un proyecto Java. Provee un conjunto de estándares de construcción, un modelo de repositorio de artefactos y un 
motor de software que administra y describe los proyectos. Maven se utiliza en la gestión y construcción de software. 
Posee la capacidad de realizar ciertas tareas claramente definidas, como la compilación del código y su empaquetado. 
Es decir, hace posible la creación de software con dependencias incluidas dentro de la estructura del JAR.

2_ Pom responde a las siglas de Project Object Model, es un fichero XML, que es la “unidad” principal de un proyecto Maven. 
Contiene información a cerca del proyecto, fuentes, test, dependencias, plugins, etc. Nos sirve porque declara datos sobre el mismo, dependencias y 
plugins a utilizar durante el ciclo de vida de la administración del proyecto.

3_ Archetype es un conjunto de herramientas para la creación de plantillas del proyecto Maven. 
Un arquetipo se define como un patrón o modelo original a partir del cual se hacen todas las demás cosas del mismo tipo . 
El nombre se ajusta a medida que intentamos proporcionar un sistema que proporcione un medio consistente para generar proyectos de Maven. 
Archetype ayudará a los autores a crear plantillas de proyectos de Maven para los usuarios, 
y proporciona a los usuarios los medios para generar versiones parametrizadas de esas plantillas de proyectos.
ArtifactId sirve para programar de una forma correcta por lo menos deberíamos construir código que sea reutilizable . 
Normalmente la reutilización esta fuertemente ligada con la modularidad. Es decir a bloques de código más pequeños mayor es la posibilidad de reutilización. 
Un Maven Artifact no es ni más ni menos que un bloque de código reutilizable.

4_ Un goal no es mas que un comando que recibe maven como parámetro para que haga algo. Maven tiene una arquitectura de plugins, para poder ampliar su funcionalidad, 
aparte de los que ya trae por defecto.
mvn clean: limpia todas las clases compiladas del proyecto.
mvn compile: compila el proyecto
mvn package: empaqueta el proyecto (si es un proyecto java simple, genera un jar, si es un proyecto web, un war, etc…)
mvn install: instala el artefacto en el repositorio local (/Users/home/.m2)

5_ El scope sirve para indicar el alcance de nuestra dependencia y su transitividad.
Compile: es la que tenemos por defecto sino especificamos scope. Indica que la dependencia es necesaria para compilar. La dependencia además se propaga en los proyectos dependientes.
Provided: Es como la anterior, pero esperas que el contenedor ya tenga esa libreria. 
Un claro ejemplo es cuando desplegamos en un servidor de aplicaciones, que por defecto, tiene bastantes librerías que utilizaremos en el proyecto, así que no necesitamos desplegar la dependencia.
Runtime: La dependencia es necesaria en tiempo de ejecución pero no es necesaria para compilar.
Test: La dependencia es solo para testing que es una de las fases de compilación con maven. JUnit es un claro ejemplo de esto.
System: Es como provided pero tienes que incluir la dependencia explicitamente. Maven no buscará este artefacto en tu repositorio local. 
Habrá que especificar la ruta de la dependencia mediante la etiqueta <systemPath>


