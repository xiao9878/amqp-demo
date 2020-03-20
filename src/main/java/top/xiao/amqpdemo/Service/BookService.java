package top.xiao.amqpdemo.Service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import top.xiao.amqpdemo.bean.Book;

@Service
public class BookService {
    //接收xiao.newsxiao消息
    @RabbitListener(queues = "xiao.news")
    public void receive(Book book) {
        System.out.println(book);
    }
    //监听消息
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
