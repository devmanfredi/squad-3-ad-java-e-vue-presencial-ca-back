package br.com.codenation.centralerros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime createdAt;

    private boolean toFile = false;

    @Enumerated(EnumType.STRING)
    private ServerOrigin serverOrigin;

    @Enumerated(EnumType.ORDINAL)
    private LevelLog levelLog;

    @ManyToOne
    private Application application;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User user;

    @OneToOne
    private LogSource logSource;
}
