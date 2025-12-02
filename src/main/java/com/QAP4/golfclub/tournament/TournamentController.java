package com.QAP4.golfclub.tournament;

import com.QAP4.golfclub.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Tournament t = tournamentService.getTournamentById(id);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/members")
    public ResponseEntity<Set<Member>> getTournamentMembers(@PathVariable Long id) {
        Set<Member> members = tournamentService.getMembersInTournament(id);
        return members != null ? ResponseEntity.ok(members) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{tournamentId}/members/{memberId}")
    public ResponseEntity<String> addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId) {
        boolean added = tournamentService.addMemberToTournament(tournamentId, memberId);
        return added ? ResponseEntity.ok("Member added successfully")
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tournament>> searchTournaments(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "location", required = false) String location) {

        if (startDate != null) {
            List<Tournament> found = tournamentService.findByStartDate(startDate);
            return found.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(found);
        }
        if (location != null && !location.isEmpty()) {
            List<Tournament> found = tournamentService.findByLocation(location);
            return found.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(found);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        return ResponseEntity.status(201).body(tournamentService.createTournament(tournament));
    }
}