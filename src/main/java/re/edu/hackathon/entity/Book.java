package re.edu.hackathon.entity;


import jakarta.persistence.*;
import lombok.*;
import re.edu.hackathon.constance.StatusType;

@Entity
@Setter
@Getter
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double price;
    private StatusType status;
    private boolean is_Deleted;
}
