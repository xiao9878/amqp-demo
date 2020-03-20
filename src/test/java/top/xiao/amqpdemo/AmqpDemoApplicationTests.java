package top.xiao.amqpdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.plugin.javascript.navig.Array;
import top.xiao.amqpdemo.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AmqpDemoApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    public void create() {
        //创建交换器
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        System.out.println("创建完成");
        //创建消息队列
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.exchange", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));

    }

    /**
     * 1.单播(点对点)
     */
    @Test
    void contextLoads() {
        //message需要自己构造一个；定义消息
//        rabbitTemplate.send();
        //只需要传入要发送的对象，自动序列化发送给rabbitMq
//        rabbitTemplate.convertAndSend();
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        //对象呗默认序列化后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "xiao.news", map);
    }

    @Test
    void receive() {
        //消息被接收后消失
        rabbitTemplate.receiveAndConvert("xiao.news");
    }

    /**
     * 广播
     */
    @Test
    void send() {
        rabbitTemplate.convertAndSend("exchange", "", new Book("", ""));
    }

}
