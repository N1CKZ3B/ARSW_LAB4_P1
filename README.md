# Escuela Colombiana de Ingeniería
# Arquitecturas de Software - ARSW
### Taller – Principio de Inversión de dependencias, Contenedores Livianos e Inyección de dependencias.

## Realizado por

* Nicolas Sebastian Achuri Macias
* Ricardo Andres Villamizar Mendez

----------------------------------------------------------------

Parte I. Ejercicio básico.

Para ilustrar el uso del framework Spring, y el ambiente de desarrollo para el uso del mismo a través de Maven (y NetBeans), se hará la configuración de una aplicación de análisis de textos, que hace uso de un verificador gramatical que requiere de un corrector ortográfico. A dicho verificador gramatical se le inyectará, en tiempo de ejecución, el corrector ortográfico que se requiera (por ahora, hay dos disponibles: inglés y español).

1. Abra el los fuentes del proyecto en NetBeans.

2. Revise el archivo de configuración de Spring ya incluido en el proyecto (src/main/resources). El mismo indica que Spring buscará automáticamente los 'Beans' disponibles en el paquete indicado.

3. Haciendo uso de la [configuración de Spring basada en anotaciones](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html) marque con las anotaciones @Autowired y @Service las dependencias que deben inyectarse, y los 'beans' candidatos a ser inyectadas -respectivamente-:

	* GrammarChecker será un bean, que tiene como dependencia algo de tipo 'SpellChecker'.

	Para ejecutar correctamente el codigo es necesario aplicar las anotaciones de manera debida, en este caso el proyecto se construye con maven sin problema alguno, sin embargo al momento de correr el main van a haber problemas, dado que no se ha asignado en ningun momento el SpellChecker que se quiera usar, en este caso la solucion al menos para GrammarChecker es utilizar las anotaciones de @Component y @Autowired para que esto funcione correctamente

	![image](https://github.com/user-attachments/assets/5c9f7d6f-1bed-4c98-8ed2-20e6b2f951e7)

		
	* EnglishSpellChecker y SpanishSpellChecker son los dos posibles candidatos a ser inyectados. Se debe seleccionar uno, u otro, mas NO ambos (habría conflicto de resolución de dependencias). Por ahora haga que se use EnglishSpellChecker.

 	Al ya tener asignadas las anotaciones en el GrammarChecker, podemos el asignar a cada uno como un servicio, ahora bien para que no se instancien ambos al mismo tiempo y no haya un problema de inyección podriamos aplicar la importacion de primary para que esto no suceda

	![image](https://github.com/user-attachments/assets/6ab92f73-3aab-401f-a36c-bb2556dac25e)


 
5.	Haga un programa de prueba, donde se cree una instancia de GrammarChecker mediante Spring, y se haga uso de la misma:

	```java
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		GrammarChecker gc=ac.getBean(GrammarChecker.class);
		System.out.println(gc.check("la la la "));
	}
	```

 	![image](https://github.com/user-attachments/assets/eb1ef11a-ad52-4ef6-a899-c1ccba29f305)

	
6.	Modifique la configuración con anotaciones para que el Bean ‘GrammarChecker‘ ahora haga uso del  la clase SpanishSpellChecker (para que a GrammarChecker se le inyecte EnglishSpellChecker en lugar de  SpanishSpellChecker. Verifique el nuevo resultado.

7.	
