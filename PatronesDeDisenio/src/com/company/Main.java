package com.company;

import com.company.behavioral.chainofresponsibility.Tarjeta;
import com.company.behavioral.command.CreditCard;
import com.company.behavioral.command.CreditCardActivateCommand;
import com.company.behavioral.command.CreditCardDesactivateCommand;
import com.company.behavioral.command.CreditCardInvoker;
import com.company.behavioral.interpreter.AndExpression;
import com.company.behavioral.interpreter.Expression;
import com.company.behavioral.interpreter.OrExpression;
import com.company.behavioral.interpreter.TerminalExpression;
import com.company.behavioral.iterator.*;
import com.company.behavioral.mediator.ConcreteColleage1;
import com.company.behavioral.mediator.ConcreteColleage2;
import com.company.behavioral.mediator.ConcreteMediator;
import com.company.behavioral.memento.Article;
import com.company.behavioral.memento.ArticleMemento;
import com.company.behavioral.memento.Carataker;
import com.company.behavioral.observer.Coche;
import com.company.behavioral.observer.MessagePublisher;
import com.company.behavioral.observer.Peaton;
import com.company.behavioral.observer.Semaforo;
import com.company.behavioral.state.MobileAlertStateContext;
import com.company.behavioral.state.Silent;
import com.company.behavioral.state.Vibration;
import com.company.behavioral.strategy.CapitalStrategyTextFormatter;
import com.company.behavioral.strategy.Context;
import com.company.behavioral.strategy.LowerStrategyTextFormatter;
import com.company.behavioral.templatemethod.*;
import com.company.behavioral.templatemethod.Visa;
import com.company.behavioral.visitor.*;
import com.company.creational.abstractfactory.*;
import com.company.creational.abstractfactory.Card;
import com.company.creational.factorymethod.Payment;
import com.company.creational.factorymethod.PaymentFactory;
import com.company.creational.factorymethod.TypePayment;
import com.company.creational.prototype.PrototypeCard;
import com.company.creational.prototype.PrototypeFactory;
import com.company.structural.bridge.ClassicCreditCard;
import com.company.structural.bridge.SecureCreditCard;
import com.company.structural.bridge.UnsecureCreditCard;
import com.company.structural.composite.CuentaAhorro;
import com.company.structural.composite.CuentaComponent;
import com.company.structural.composite.CuentaComposite;
import com.company.structural.composite.CuentaCorriente;
import com.company.structural.decorator.*;
import com.company.structural.decorator.Credit;
import com.company.structural.facade.CreditMarket;
import com.company.structural.flyweight.Enemy;
import com.company.structural.flyweight.EnemyFactory;
import com.company.structural.proxy.Internet;
import com.company.structural.proxy.ProxyInternet;

import java.util.Random;

import static com.company.creational.prototype.PrototypeFactory.CartType.AMEX;
import static com.company.creational.prototype.PrototypeFactory.CartType.VISA;

public class Main {

    public static void main(String[] args) {

        //CREACIONALES
	    //probarFactoryMethod();
        //probarAbstractFactory();
        //probarBuilder();
        //probarPrototype();
        //probarSinglenton();

        //COMPORTAMIENTO
        //probarChainOfResponsability();
        //probarCommand();
        //probarIterator();
        //probarMediator();
        //probarMemento();
        //probarObserver();
        //probarState();
        //probarInterpreter();
        //probarStrategy();
        //probarTemplateMethod();
        //probarVisitor();

        //STRUCTURAL
        //probarAdapter();
        //probarBridge();
        //probarComposite();
        //probarDecorator();
        //probarFacade();
        //probarFlyweight();
        //probarProxy();

    }

    private static void probarProxy(){
    	//Se utiliza como intermediario para acceder a un objeto, actúa como sustituto del objeto original
    	//Las llamadas al objeto acaban ocurriendo indirectamente a través del objeto proxy
    	//El patrón proxy se divide en cuatro grupos: 
    	//Proxy remoto: Representa un objeto que está remoto 
    	//Proxy virtual: Crea objetos costosos por encargo, solo se habilitan los módulos cuando los usa el usuario
    	//Proxy de protección: Se encarga de controlar el acceso a un objeto, ofrece seguridad
    	//Smart proxy: Suele encargarse de hacer tareas de limpieza adicionales cuando un cliente accede a un objeto
    	//Ventajas: No ofrece mucha más seguridad a la hora de acceder al objeto
    	//evitamos la dupllicación de objetos, mejorando el rendimiento
    	//Desventajas: Estamos añadiendo otra capa de abstracción al código y algunos clienes pueden acceder
    	//directamente al RealSubject o al Proxy y esto puede generar errores
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("udemy.com");
            internet.connectTo("facebook.com");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void probarFlyweight(){
    	//Un flyweight es un objeto compartido que se puede usar en múltiples contextos simultaneamente
    	//el flyweigth actúa como un objeto independiente en cada contexto y de ahí su ventaja
    	//Al compartir estados para soportar un gran número de objetos pequeños aumentamos la eficiencia 
    	//de espacio en memoria
    	//Es muy util cuando necesitamos muchos objetos similares que solo se diferencian en unos pocos 
    	//parámetros pero que el resto de parámetros son comunes al resto de los objetos
    	//Usa menos memoria porque permite crear menos objetos compartirlos
    	//Ventajas: Reduce mucho la cantidad de memoria, reduce el número de objetos en memoria
    	//Desventajas: Suele ser complicado y puede ser de dificil depuración
        for(int i=0; i<15; i++){
        	//Aunque se hayan creado 15 enemigos solo se han usado dos objetos, un asesino y un detective
            Enemy enemy = EnemyFactory.getEnemy(getRandomEnemyType());
            enemy.setWeapon(getRandomWeapon());
            enemy.lifePoints();
        }
    }

    private static String getRandomWeapon(){
        Random r = new Random();
        int randInt = r.nextInt(weapon.length);
        return weapon[randInt];
    }

    private static String getRandomEnemyType(){
        Random r = new Random();
        int randInt = r.nextInt(enemyType.length);
        return enemyType[randInt];
    }

    private static String[] enemyType = {"Asesino", "Detective"};
    private static String[] weapon = {"Fusil", "Revolver", "Pistola", "Metralleta", "Lanza Granadas", "9mm"};

    private static void probarFacade(){
    	//Busca simplificar el sistema para el cliente proporcionando una interfaz unificada
    	//para un conjunto de subsistemas
    	//Cuando tenemos un sistema complejo y queremos exponer su uso de manera simplificada
    	//esta debe ser la opción a utilizar
    	//Su objetivo final es ocultar la complejidad interna a través de una única interfaz
    	//que parece simple de utilizar desde un punto de vista exterior
    	//Ventajas: Hace muy facil la implementación al cliente al ofrecer una interfaz simple 
    	//con todos los objetos que se usan
    	//Desventajas: Puede ser dificail de implementar cuando el subsistema es complejo
        CreditMarket creditMarket = new CreditMarket();
        creditMarket.showCreditBlack();
        creditMarket.showCreditGold();
        creditMarket.showCreditSilver();
    }

    private static void probarDecorator(){
    	/*
    	 * Se utiliza para agregar características adicionales a una instancia particular de un clase
    	 * sin alterar las instancias de la misma clase
    	 * Implica que decorar un objeto cambia su comportamiento pero no su interfaz
    	 * Si queremos añadir mas responsabilidades a un objeto de clase pero no a toda la clase 
    	 * esta es la mejor opción
    	 * Ventajas: Es más sencillo que usar herencia, podemos crear muchas combinaciones de 
    	 * comportamientos distintos
    	 * Desventajas: Nos obliga a crear muchos objetos encadenados por ello es dificil de depurar
    	 */
        com.company.structural.decorator.Credit gold = new com.company.structural.decorator.Gold();

        com.company.structural.decorator.Credit blackInternationalPayment = new com.company.structural.decorator.Black();
        blackInternationalPayment = new InternationalPaymentDecorator(blackInternationalPayment);

        com.company.structural.decorator.Credit goldSecureInternational = new com.company.structural.decorator.Gold();
        goldSecureInternational = new InternationalPaymentDecorator(goldSecureInternational);
        goldSecureInternational = new SecureDecorator(goldSecureInternational);
        //Se podría añadir un nuevo ConreteDecorator a goldSecureInternational sin modificar este código

        System.out.println("----Tarjeta Gold con configuración----");
        gold.showCredit();

        System.out.println("----Tarjeta Black con configuración----");
        blackInternationalPayment.showCredit();

        System.out.println("----Tarjeta Gold2 con configuración----");
        goldSecureInternational.showCredit();

    }

    private static void probarComposite(){
    	/*
    	 * Se usa para construir objetos complejos desde objetos mas simples
    	 * Ventajas: Agregar nuevos componentes siempre es sencillo y no cambia el código del cliente
    	 * (Ej: CuentaHipoteca)
    	 * Desventajas: Es dificil de depurar porque se pueden crear muchos pequeños objetos encadenados
    	 */
        CuentaComponent cuentaCorrienteAlberto = new CuentaCorriente(1000.0, "Alberto");
        CuentaComponent cuentaAhorroAlberto = new CuentaAhorro(20000.0, "Alberto");
        CuentaComponent cuentaAhorroAlex = new CuentaAhorro(20000.0, "Alex");

        CuentaComposite cuentaComposite = new CuentaComposite();
        cuentaComposite.addCuenta(cuentaCorrienteAlberto);
        cuentaComposite.addCuenta(cuentaAhorroAlberto);
        cuentaComposite.addCuenta(cuentaAhorroAlex);

        cuentaComposite.showAccountName();
        cuentaComposite.getAmount();
    }

    private static void probarBridge(){
    	/*
    	 * Se utiliza cuando queremos desacoplar una abstracción de su implementación para que los dos
    	 * puedan variar independientemente
    	 * Implica una interfaz que actúa como puente, de ahí su nombre 
    	 * Ventajas: Los cambios en la implementación de una abstracción no nos afectan al cliente
    	 * Mejora la extensibilidad
    	 * Desventajas: Se usan muchas clases
    	 */
        com.company.structural.bridge.AbstractCreditCard classic = new ClassicCreditCard(new UnsecureCreditCard());
        classic.realizarPago();

        classic = new ClassicCreditCard(new SecureCreditCard());
        classic.realizarPago();
    }

    private static void probarAdapter(){
    	/*
    	 * Sirve para que dos interfaces no relacionadas puedan trabajar juntas
    	 * El objetos que une estas interfaces se llamará adapter y será un adaptador entre las dos interfaces
    	 * Ventajas: Permite trabajar a clases que tienen interfaces incompatibles
    	 * Desventajas: Se necesitan muchas clases y muchos adaptadores, si ve el código otro desarrollador
    	 * le puede resultar complejo comprenderlo
    	 */
        com.company.structural.adapter.CreditCard creditCard = new com.company.structural.adapter.CreditCard();
        creditCard.pay("classic");
        creditCard.pay("gold");
        creditCard.pay("black");
        creditCard.pay("silver");
    }

    private static void probarVisitor(){
    	/*
    	 * Permite separar un algoritmo de la estructura del objeto en la que opera
    	 * esto nos permite agregar nuevas operaciones a la estructura del objeto sin modificar dicha estructura
    	 * Ventajas: Agregar nuevas operaciones solo requiere un cambio en la interfaz e implementarlo en el visitante
    	 * Desventajas: Si tenemos muchas implementaciones de la interfaz visitante element será costosa su extensión
    	 */
        OfertaElement ofertaElement = new OfertaGasolina();
        ofertaElement.accept(new BlackCreditCardVisitor());

        ofertaElement = new OfertaVuelos();
        ofertaElement.accept(new ClassicCreditCardVisitor());
    }

    private static void probarTemplateMethod(){
    	/*
    	 * Define los pasos secuenciales para ejecutar un algoritmo de varios pasos
    	 * Define la estructura del algoritmo y su lógica será implementada por las subclases
    	 * Por ello se llama template, es una plantilla
    	 * Ventajas: Nos ahorra duplicar el código, está todo en la clase abstracta
    	 * podemos reutilizar el código de una manera muy sencilla
    	 * Desventaja: Se acaban creando muchas clases
    	 */
        com.company.behavioral.templatemethod.Payment payment = new Visa();
        payment.makePayment();

        payment = new Paypal();
        payment.makePayment();
    }

    private static void probarStrategy(){
    	/*
    	 * Nos permite elegir una especificación específica de algoritmo o tarea 
    	 * en tiempo de ejecución de otras implementaciones para la misma tarea
    	 * En tiempo de ejecución es la aplicación la que decide qué algoritmo va a usar en dicho momento
    	 * Por tanto en función de la tarea en la que estemos podremos elegir la implementación
    	 * sin alterar el flujo de trabajo de nuestra aplicación
    	 * Tendremos una estrategia que nos permitirá escribir en mayúsculas o en minúsculas
    	 * Podemos seleccionar por ejemplo convertir a inglés, se puede ampliar fácilmente
    	 * No necesitaremos los if else anidados
    	 * Desventajas: La aplicación debe conocer todas las estrategias para seleccionar la correcta
    	 */
    	com.company.behavioral.strategy.Context context = new com.company.behavioral.strategy.Context(new CapitalStrategyTextFormatter());
        context.publishText("Este texto será convertido a MAYUSCULAS a través del algoritmo");

        context = new com.company.behavioral.strategy.Context(new LowerStrategyTextFormatter());
        context.publishText("Esto texto SERA CONVERTIDO a MINUSCULAS a través del algortimo");
    }

    private static void probarInterpreter(){
    	/*
    	 * Dado un lenguaje tiene una representación para su gramática junto con un interprete del lenguaje
    	 * Se suele utilizar para definir un lenguaje para representar expresiones regulares 
    	 * para buscar cadenas dentro de otras cadenas
    	 * Es el patrón que menos se utiliza
    	 * Es facil cambiar la gramática a través de la herencia
    	 * Es sencillo introducir nuevas formas de interpretar las expresiones en la gramática, 
    	 * creando nuevas clases ej: XorExpression.java
    	 * Desventajas: No es eficiente y es complejo
    	 */
        Expression cero = new TerminalExpression("0");
        Expression uno = new TerminalExpression("1");

        Expression containBoolean = new OrExpression(cero, uno);
        Expression containsOneAndCero = new AndExpression(cero, uno);

        System.out.println(containBoolean.interpret("cero"));
        System.out.println(containBoolean.interpret("0"));

        System.out.println(containsOneAndCero.interpret("0"));
        System.out.println(containsOneAndCero.interpret("0, 1"));
    }

    private static void probarState(){
    	/*
    	 * Un objeto modificará su comportamiento cada vez que cambia su estado interno
    	 * Vamos a controlar una alarma del movil, que puede ser silenciosa, con vibración o con sonido
    	 * Nos permite agregar fácilmente nuevos estados
    	 * Nos ayuda a reducir el número de sentencias IF ELSE
    	 * Desventaja: tenemos un gran número de clases
    	 */
        MobileAlertStateContext context = new MobileAlertStateContext();
        context.alert();
        context.alert();
        context.setState(new Vibration());
        context.alert();
        context.alert();
        context.setState(new Silent());
        context.alert();
        context.alert();
    }

    private static void probarObserver(){
    	/*
    	 * No permite implementar una estrategia que reacciona a los cambios de estado del objeto observado.
    	 * Se usa cuando queremos detectarveventos en tiempo de ejecución
    	 * Cuando hay una dependencia de uno a muchos y un objeto debe notificar a 
    	 * muchos objetos que ha cambiado
    	 * Podemos añadir un nuevo observer entiempo de ejecución sin nigún problema. Ej: camión
    	 * Un objeto subject envía su notificación a todos los que están observando
    	 * Deventajas: Su implementación al inicio resulta complicada
    	 */
    	
        Coche coche = new Coche();
        Peaton peaton = new Peaton();
        MessagePublisher messagePublisher = new MessagePublisher();

        messagePublisher.attach(coche);
        messagePublisher.attach(peaton);
        messagePublisher.notifyUpdate(new Semaforo("ROJO_COCHE"));
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        messagePublisher.notifyUpdate(new Semaforo("VERDE_COCHE"));
    }

    private static void probarMemento(){
    	/*
    	 * Se utiliza para restaurar el estado de un objeto a un estado anterior
    	 * Es un punto de restauración en el cicle de vida de un objeto
    	 * Permite restaurar sin romper la encapsulación
    	 * Se permiten descartar los cambios no deseado y devolver el objeto a un estado correcto
    	 * Desventaja: Un alto número de mementos requiere mayor almacenamiento
    	 * 
    	 */
        Carataker carataker = new Carataker();
        Article article = new Article("Alberto", "Memento es una pelicula");
        article.setText(article.getText() + " de Nolan");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());
        article.setText(article.getText() + " protagonizada por Guy Pearce");
        System.out.println(article.getText());

        carataker.addMemento(article.createMemento());

        article.setText(article.getText() + " y Leonardo DiCaprio");
        System.out.println(article.getText());

        ArticleMemento memento1 = carataker.getMemento(0);
        ArticleMemento memento2 = carataker.getMemento(1);

        article.restoreMemento(memento1);
        System.out.println(article.getText());


        article.restoreMemento(memento2);
        System.out.println(article.getText());

        article.setText(article.getText() + " del aÃ±o ");

    }

    private static void probarMediator(){
    	/*
    	 * Vamos a hacer un chat
    	 * Desacopla los colleage
    	 * Cuando tenemos una comunicación muchos a muchos, como en un chat con varios usuarios
    	 * reemplaza esta lógica a uno a muchos
    	 * El objeto no necesita conocer todos los objetos con lo que se va a comunicar, 
    	 * y solo necesita conocer el mediator
    	 * Sirve para cuando hay muchas clases que se relacionan entre si
    	 * Desventaja: La clase ConcreteMediator puede llegar a ser muy compleja
    	 */
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user1");
        user2.send("Hola user1, soy user2");
    }

    private static void probarIterator(){
    	/*
    	 * Nos permite poder acceder de manera secuencial a los elementos de una colección
    	 * sin exponer su estructura interna de los elementos o la colección en si
    	 * Desde este patrón volver a ver los videos iniciales y aumentar la documentación
    	 * Podemos acceder a una coleccción de objetos sin conocer el código de dichos objetos
    	 * Desventajas: Este patrón ya está hecho y no tenemos que volver a escribir el código
    	 */
        com.company.behavioral.iterator.Card[] cards = new com.company.behavioral.iterator.Card[5];
        cards[0] = new com.company.behavioral.iterator.Card("VISA");
        cards[1] = new com.company.behavioral.iterator.Card("AMEX");
        cards[2] = new com.company.behavioral.iterator.Card("MASTER CARD");
        cards[3] = new com.company.behavioral.iterator.Card("GOOGLE CARD");
        cards[4] = new com.company.behavioral.iterator.Card("APPLE CARD");

        com.company.behavioral.iterator.List lista = new CardList(cards);
        Iterator iterator = lista.iterator();

        while (iterator.hasNext()){
        	//Podemos acceder a una coleccción de objetos sin conocer el código de dichos objetos
        	com.company.behavioral.iterator.Card tarjeta = (com.company.behavioral.iterator.Card)iterator.currentItem();
            System.out.println(tarjeta.getType() + "( obtenido con currentItem())");
            tarjeta = (com.company.behavioral.iterator.Card)iterator.next();
            System.out.println(tarjeta.getType() + "( obtenido con next())");
        }

    }



    private static void probarCommand(){
    	/*
    	 * Se utiliza para encapsular toda la información necesaria para realizar una opción o 
    	 * desencadenar un evento en cualquier momento
    	 * Estará formada por comandos de ahí el nombre de command
    	 * Nos permite desacoplar el objeto que invoca a una operación de aquellos que tiene el
    	 * conocimiento necesario para poder realizarla	 
    	 * Hace que nuestro código sea extendible
    	 * Reduce el acoplamiento de nuestra clase invoker con el receptor del comando
    	 * Desventaja: Incrementa el número de clases a crear
    	 */
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDeactivate= new CreditCard();

        CreditCardInvoker invoker = new CreditCardInvoker();

        //Reduce el acoplamiento de nuestra clase invoker con el receptor del comando
        invoker.setCommand(new CreditCardActivateCommand(creditCard));
        invoker.run();
        System.out.println("--------------------");
        //Reduce el acoplamiento de nuestra clase invoker con el receptor del comando
        invoker.setCommand(new CreditCardDesactivateCommand(creditCardDeactivate));
        invoker.run();
    }

    private static void probarChainOfResponsability(){
    	/*
    	 * Permite que varias clases intenten manejar una solicitud y no sabemos a priori qué objeto 
    	 * debe manejar dicho problema. Si un objeto no sabe manejar la solicitud se la pasa al siguiente.
    	 * Se reduce el acoplamiento
    	 * Permite agregar o eliminar elementos de la cadena de forma muy sencilla
    	 * Desventajas: Cuesta la depuración, es el programador el que debe garantizar
    	 * que se recojen todos los casos posibles en el if (totalLoan <= cantidad)
    	 */
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.crediCardRequest(100000);
    }

    private static void probarSinglenton(){
    	/*
    	 * Nos permite que el mismo objeto sea compartido en distintas partes del código
    	 * Una clase solo tendrá una instancia y se proporciona un punto de acceso gobal a esta
    	 * Nos permite tener un acceso controlado a la única instancia de la clase
    	 * Los típicos ejemplos son la conexión a una BBDD o un webservice
    	 * Desventajas: Es muy dificil testear el código cuando se usa un singleton
    	 */
        com.company.creational.singlenton.Card.getINSTANCE().setCardNumber("1234-1234-1234-1324");
        System.out.println(com.company.creational.singlenton.Card.getINSTANCE().getCardNumber());
        com.company.creational.singlenton.Card.getINSTANCE().setCardNumber("4321-4321-4321-4321");
        System.out.println(com.company.creational.singlenton.Card.getINSTANCE().getCardNumber());
    }

    private static void probarPrototype(){
    	/*
    	 * Permite que un objeto cree una copia de si mismo sin conocer su clase ni ningún detalle
    	 * de cómo crearlo
    	 * Sirve para crear clases complejas
    	 * Clonar un objeto siempre es más rápido que crearlo
    	 * Si el coste de crear un objeto es muy grande lo mejor que se puede hacer es clonar
    	 * Ideal para crear las instancias en tiempo de ejecución
    	 * Desacoplamos la creación de objetos y evitamos repetir la instanciación con parámetros repetidos
    	 */
        PrototypeFactory.loadCard();
        try {
            PrototypeCard visa = PrototypeFactory.getInstance(VISA);
            visa.getCard();

            PrototypeCard amex = PrototypeFactory.getInstance(AMEX);
            amex.getCard();

        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    private static void probarBuilder(){
    	/*
    	 * Nos permite crear objetos complejos a partir de partir de un objeto fuente,
    	 * el objeto fuente se denomina producto y nos permite concentrar el proceso de creación en un punto
    	 * Se usará cuando nuestro sistema objetos complejos compoestos po muchos atributos
    	 * pero el número de configuraciones será limitado.
    	 * Reduce el acoplamiento, esto es lo que hay que buscar a la hora de hacer un buen diseño
    	 * Nos permite crear estructuras complejas respetando la interfaz común de la clase Builder
    	 * El código de construcción es independiente del de representación
    	 * Tenemos mayor control en la creación de objetos
    	 */
        com.company.creational.builder.Card card = new com.company.creational.builder.Card.CardBuilder("VISA",
                "0000 1111 2222 3333")
                .name("Alberto")
                .expires(2030)
                .credit(true)
                .build();

        System.out.println(card);

        com.company.creational.builder.Card card2 = new com.company.creational.builder.Card.CardBuilder("AMEX",
                "9999 9999 9999 9999")
                .build();

        System.out.println(card2);
    }

    private static void probarAbstractFactory(){
    	/*
    	 * Es una fábrica de fábricas del patrón FactoryMethod
    	 * Se utilizará cuando usistema debe ser independiete de cóm son creados sus objetos
    	 * Ocultamos a los clientes las clases de implementación, aisla el código del cliente de las clases concretas
    	 * Se usa cuando el sistema debe ser independiente de como se crean, se componen y se representan
    	 * los objetos que son necesarios
    	 * Desventajas: Para crear los productos deben modificarse tanto las fabricas abstractas como las concretas
    	 */ 
        AbstractFactory abstractFactoryCard = FactoryProvider.getFactory("Card");
        Card tarjeta = (Card) abstractFactoryCard.create("VISA");

        AbstractFactory abstractFactoryPayment = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactoryPayment.create("DEBIT");

        System.out.println("Un tarjeta de tipo: " + tarjeta.getCardType() + " con el metodo de pago: " + paymentMethod.doPayment());
    }

    private static void probarFactoryMethod(){
    	/*
    	 * El objetivo es liberar a los programadores de la creación de objetos de la forma correcta
    	 * Necesitamos crear una instancia de un objeto que a priori no sabemos que tipo va a ser
    	 * Si el día de mañana queremos crear un nuevo ConcreteProduct(PayPalPayment) solo habría que 
    	 * añadirlo a concreteCreator(PaymentFactory)
    	 * Se desacopla la forma en la creación de los objetos
    	 * Gran facilidad para crear un objeto
    	 * Desventaja: No obliga a crear bastantes clases
    	*/
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }
}
