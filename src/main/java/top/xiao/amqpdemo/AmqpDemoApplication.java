package top.xiao.amqpdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1.RabbitAutoConfiguration
 * 2.又自动配置了连接工厂ConnectionFacto
 * 3.RabbProperti 封装了 RabbitQM的配置
 * 4.RabbbitTemplate :给rabbitMQ发送和接收消息
 * 5.AmqpAdmin： RabbitMQ系统管理功能组件
 *  AmqpAdmin:创建和删除queue
 * 6.@EnableRabbit+@RabbitListener监听消息队列的内容
 */
@EnableRabbit//开启基于注解的RabbiMQ模式
@SpringBootApplication
public class AmqpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpDemoApplication.class, args);
    }

}
