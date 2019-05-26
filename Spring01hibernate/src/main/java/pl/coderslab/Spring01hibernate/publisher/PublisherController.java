package pl.coderslab.Spring01hibernate.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherDao publisherDao;

    @RequestMapping("/add")
    @ResponseBody
    public Publisher add() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisherDao.persist(publisher);
        return publisher;
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public Publisher merge(@PathVariable("id")long id) {
        return publisherDao.findById(id);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAllPublishers() {
        return publisherDao.findAll()
                .stream()
                .map(this::buildString)
                .collect(Collectors.joining("<br />"));
    }

    private String buildString(Publisher publisher) {
        return new StringBuilder()
                .append("Id: ")
                .append(publisher.getId())
                .append(" ")
                .append("Nazwa: ")
                .append(publisher.getName())
                .toString();
    }

    @RequestMapping("/changeName/{id}/{name}")
    @ResponseBody
    public String changeDescription(@PathVariable("name") String name, @PathVariable("id") long id) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.merge(publisher);
        return "Żądanie zakończone sukcesem";
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.remove(publisher);
        return "Żądanie zakończone sukcesem";
    }

}
