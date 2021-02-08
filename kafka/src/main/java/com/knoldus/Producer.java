package com.knoldus;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
import java.util.Random;


public class Producer {
    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "com.knoldus.UserSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer<String, User>(properties);
        try{
            Random rand = new Random();
            for(int i = 1; i <= 10; i++){
                User user = new User(i, "Priya", rand.nextInt(10)+20, "MCA");
                System.out.println("Message " + user.toString() + " sent !!");
                kafkaProducer.send(new ProducerRecord<>("user", String.valueOf(i), user));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.close();
        }
    }
}