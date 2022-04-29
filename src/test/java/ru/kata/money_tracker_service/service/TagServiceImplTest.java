//package ru.kata.money_tracker_service.service;
//
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import ru.kata.money_tracker_service.model.Tag;
//
//import java.util.List;
//import java.util.Objects;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class TagServiceImplTest {
//
//    @Autowired
//    private TagServiceImpl tagService;
//
//    private final Tag tag1 = new Tag(0L, 1L, "tag_title_1");
//    private final Tag tag2 = new Tag(0L, 2L, "tag_title_2");
//
//    @Test
//    void save() {
//        tagService.save(tag1);
//        tagService.save(tag2);
//        tagService.deleteAll();
//    }
//
//    @Test
//    void update() {
//        tagService.save(tag1);
//        long id = tagService.findAll().get(0).getId();
//        Tag tag = tagService.findById(id).orElse(null);
//        assert tag != null;
//        tag.setTitle("update_tag_title_1");
//        tagService.update(tag);
//
//        Tag updateTag = tagService.findAll().get(0);
//        if (!Objects.equals(tag.getTitle(), updateTag.getTitle())) {
//            Assertions.fail("objects are different, update");
//        }
//        tagService.deleteAll();
//    }
//
//    @Test
//    void findById() {
//        tagService.save(tag1);
//        long id = tagService.findAll().get(0).getId();
//        Tag tagFromDb = tagService.findById(id).orElse(null);
//        assert tagFromDb != null;
//        if (tagFromDb.getId() != id ||
//                !Objects.equals(tagFromDb.getTitle(), tag1.getTitle())) {
//            Assertions.fail("objects are different, findById");
//        }
//        tagService.deleteAll();
//
//    }
//
//    @Test
//    void findAll() {
//        tagService.save(tag1);
//        tagService.save(tag2);
//        List<Tag> list = tagService.findAll();
//
//        if (list.size() != 2) {
//            Assertions.fail("findAll doesn't work, List.size() = " + list.size());
//        }
//        tagService.deleteAll();
//    }
//
//    @Test
//    void deleteById() {
//        tagService.save(tag1);
//        tagService.save(tag2);
//        long id1 = tagService.findAll().get(0).getId();
//        long id2 = tagService.findAll().get(1).getId();
//        tagService.delete(id1);
//        tagService.delete(id2);
//        List<Tag> list = tagService.findAll();
//        if (list.size() != 0) {
//            Assertions.fail("deleteById doesn't work");
//        }
//        tagService.deleteAll();
//    }
//
//    @Test
//    void deleteAll() {
//        tagService.save(tag1);
//        tagService.save(tag2);
//        tagService.deleteAll();
//        List<Tag> list = tagService.findAll();
//        if (list.size() != 0) {
//            Assertions.fail("deleteAll doesn't work");
//        }
//    }
//}