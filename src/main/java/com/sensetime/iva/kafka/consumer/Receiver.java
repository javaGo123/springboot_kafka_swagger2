package com.sensetime.iva.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;

//import java.util.concurrent.CountDownLatch;

public class Receiver {

//  private CountDownLatch latch = new CountDownLatch(1);
//
//  public CountDownLatch getLatch() {
//    return latch;
//  }

  @KafkaListener(topics = "${kafka.topic.helloword}")
  public void receive(String payload) {
    System.out.println("received payload='{"+payload+"}'");
//    latch.countDown();
  }
}