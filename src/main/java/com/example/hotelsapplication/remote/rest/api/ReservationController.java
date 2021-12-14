package com.example.hotelsapplication.remote.rest.api;

import com.example.hotelsapplication.domain.model.ReservationStatusType;
import com.example.hotelsapplication.remote.rest.dto.common.PersonReservationDto;
import com.example.hotelsapplication.remote.rest.dto.common.RoomReservationDto;
import com.example.hotelsapplication.remote.rest.dto.response.ReservationDto;
import com.example.hotelsapplication.remote.rest.dto.response.ReservationStatusDto;
import com.example.hotelsapplication.remote.rest.dto.response.TokenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.hotelsapplication.domain.model.ReservationStatusType.NEW;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/reservations",produces = APPLICATION_JSON_VALUE)
@RestController
public class ReservationController {
    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody ReservationDto reservationDto){
        return ResponseEntity.ok(null);
    }
    @GetMapping
    public ResponseEntity<ReservationStatusDto> getOrders(@RequestParam("status") ReservationStatusType reservationStatusType, @RequestHeader("Access-Token") String token ){
        RoomReservationDto roomReservationDto = new RoomReservationDto(3,1,14);
        PersonReservationDto personReservationDto = new PersonReservationDto("Jan Kowalski","123456","Branickiego 34/2",1);
        ReservationDto reservationDto = new ReservationDto(1,NEW, List.of(roomReservationDto),personReservationDto);
        ReservationStatusDto reservationStatusDto = new ReservationStatusDto(List.of(reservationDto));
        return ResponseEntity.ok(reservationStatusDto);
    }
    @DeleteMapping("/{reservation-id}")
    public ResponseEntity<Void> deleteReservation(@RequestHeader("Access-Token") String token, @PathVariable("reservation-id") Integer reservationId ) {
        return ResponseEntity.ok().build();
    }
}