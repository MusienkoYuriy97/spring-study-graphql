package com.example.springstudygraphql.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REFRESH;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;


@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "Member.school",
                attributeNodes = @NamedAttributeNode("school")
        ),
        @NamedEntityGraph(name = "Member.documents",
                attributeNodes = @NamedAttributeNode("documents")
        )
}
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String address;

    @ManyToOne(fetch = LAZY, cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private School school;

    @Builder.Default
    @Enumerated(STRING)
    private Role role = Role.STUDENT;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
        document.setMember(this);
    }
}
