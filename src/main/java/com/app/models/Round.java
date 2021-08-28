package com.app.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "round")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "round_player",
            joinColumns = {@JoinColumn(name = "round_id")},
            inverseJoinColumns = {@JoinColumn(name = "player_id")}
    )
    private Set<Player> players = new HashSet<>();

    private String description;

    private BigDecimal result;

}


