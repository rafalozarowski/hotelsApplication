package com.example.hotelsapplication.data.entity.hotel;

import com.example.hotelsapplication.data.entity.room.RoomEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hotels")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "room")
    private Set<RoomEntity> rooms;
    @Column(name = "name")
    private String name;
}