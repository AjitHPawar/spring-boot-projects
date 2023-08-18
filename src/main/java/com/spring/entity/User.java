package com.spring.entity;

import com.spring.util.AuditableBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "email"
                )
        }
)
public class User extends AuditableBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String email;
    private String role;
    private String password;
    private String contact;
    private Integer age;
    private String nationality;
    private boolean active;

}
