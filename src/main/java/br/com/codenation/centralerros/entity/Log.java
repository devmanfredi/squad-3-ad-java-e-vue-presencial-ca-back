package br.com.codenation.centralerros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 120)
    private String title;

    @NotNull
    @Size(max = 2500)
    private String details;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    @NotNull
    @Size(max = 255)
    private String collectedBy;

    @Enumerated(EnumType.STRING)
    private LevelLog level;

    @ManyToOne
    private User user;

    @OneToMany
    private List<LogSource> logSource;

}
