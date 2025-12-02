package com.QAP4.golfclub.tournament;

import com.QAP4.golfclub.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private com.QAP4.golfclub.member.MemberRepository memberRepository;

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long id) {
        Optional<Tournament> optional = tournamentRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Tournament> findByStartDate(LocalDate date) {
        return tournamentRepository.findByStartDate(date);
    }

    public List<Tournament> findByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }

    public Set<Member> getMembersInTournament(Long tournamentId) {
        Tournament t = getTournamentById(tournamentId);
        return t != null ? t.getParticipatingMembers() : null;
    }

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public boolean addMemberToTournament(Long tournamentId, Long memberId) {
        Optional<Tournament> tOpt = tournamentRepository.findById(tournamentId);
        Optional<Member> mOpt = memberRepository.findById(memberId);

        if (tOpt.isPresent() && mOpt.isPresent()) {
            Tournament tournament = tOpt.get();
            Member member = mOpt.get();
            tournament.getParticipatingMembers().add(member);
            tournamentRepository.save(tournament);
            return true;
        }
        return false;
    }
}