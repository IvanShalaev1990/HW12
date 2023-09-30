package org.task.two;

public class TaskTwoTest {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Thread threadProducer = new Thread(processor::producer);
        Thread threadConsumer = new Thread(processor::consumer);
        Thread threadConsumerFizzBuzz = new Thread(processor::consumerFizzBuzz);
        Thread threadConsumerFizz = new Thread(processor::consumerFizz);
        Thread threadConsumerBuzz = new Thread(processor::consumerBuzz);
        threadProducer.start();
        threadConsumerFizzBuzz.start();
        threadConsumerFizz.start();
        threadConsumerBuzz.start();
        threadConsumer.start();
    }
}
