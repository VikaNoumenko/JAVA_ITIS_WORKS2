package ru.itis;

public class Main {

    public static void main(String[] args) {

        //renderer.render(new MessageHelloImpl());
        //renderer.render(new MessageByeImpl());
        ComponentFactory factory = new ComponentFactory();

        Message message = factory.getComponent(Message.class);
        MessageRenderer renderer = factory.getComponent(MessageRenderer.class);

        renderer.render(message);
    }
}
