package com.blog.demo.model;

import javax.persistence.*;


    @Entity
    @Table(name = "blog")
    public class Blog {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String content;
        private String description;

        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name = "category_id", referencedColumnName = "id")
        private Category category;

        public Blog() {
        }

        public Blog(String content, String description) {
            this.content = content;
            this.description = description;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
}
