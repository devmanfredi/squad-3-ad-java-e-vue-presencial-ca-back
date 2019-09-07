package br.com.codenation.centralerros.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String code;

    @NotNull
    @Size(max = 120)
    private String name;

    @NotNull
    @Size(max = 10)
    private String password;

    @NotNull
    @Email
    @Size(max = 50)
    private String email;

    private Integer itensPerPage;

    @NotNull
    @Size(max = 120)
    private String token;

    @NotNull
    private LocalDateTime creationDate;

    private Boolean active;

    @ManyToOne
    private Company company;
}
