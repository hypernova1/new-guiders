package io.guiders.api.service;

import io.guiders.api.domain.Guider;
import io.guiders.api.domain.Member;
import io.guiders.api.payload.MemberDto;
import io.guiders.api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ModelMapper modelMapper;

    private final MemberRepository memberRepository;

    public Member joinMember(MemberDto.JoinRequest joinRequest) {

        Member member = modelMapper.map(joinRequest, Guider.class);

        return memberRepository.save(member);

    }



}
