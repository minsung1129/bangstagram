package com.bangstagram.room.service;

import com.bangstagram.common.exception.DoNotExistException;
import com.bangstagram.room.controller.dto.request.RoomSaveRequestDto;
import com.bangstagram.room.controller.dto.request.RoomUpdateRequestDto;
import com.bangstagram.room.controller.dto.request.ThemeSaveRequestDto;
import com.bangstagram.room.controller.dto.request.ThemeUpdateRequestDto;
import com.bangstagram.room.controller.dto.response.RoomResponseDto;
import com.bangstagram.room.domain.model.Room;
import com.bangstagram.room.domain.model.Theme;
import com.bangstagram.room.domain.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional(readOnly = true)
    public List<RoomResponseDto> findAll() {
        return roomRepository.findAll().stream()
                .map(room -> RoomResponseDto.builder()
                        .title(room.getTitle())
                        .address(room.getAddress())
                        .link(room.getLink())
                        .phone(room.getPhone())
                        .description(room.getDescription())
                        .themes(room.getThemes())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RoomResponseDto findById(Long id) {
        Room room = findRoomById(id);
        return RoomResponseDto.builder()
                .title(room.getTitle())
                .address(room.getAddress())
                .link(room.getLink())
                .phone(room.getPhone())
                .description(room.getDescription())
                .themes(room.getThemes())
                .build();
    }

    public RoomResponseDto createRoom(RoomSaveRequestDto requestDto) {
        Room room = roomRepository.save(requestDto.toEntity());

        return RoomResponseDto.builder()
                .id(room.getId())
                .title(room.getTitle())
                .address(room.getAddress())
                .link(room.getLink())
                .phone(room.getPhone())
                .description(room.getDescription())
                .themes(room.getThemes())
                .build();
    }

    @Transactional
    public RoomResponseDto updateRoom(Long id, RoomUpdateRequestDto roomUpdateRequestDto) {
        Room room = findRoomById(id);
        room.update(roomUpdateRequestDto.getTitle(), roomUpdateRequestDto.getLink(), roomUpdateRequestDto.getPhone(),
                roomUpdateRequestDto.getAddress(), roomUpdateRequestDto.getDescription());

        return RoomResponseDto.builder()
                .id(room.getId())
                .title(room.getTitle())
                .address(room.getAddress())
                .link(room.getLink())
                .phone(room.getPhone())
                .description(room.getDescription())
                .themes(room.getThemes())
                .build();
    }

    public List<RoomResponseDto> findRoomByRegion(String region) {
        return roomRepository.findByAddressContaining(region).stream()
                .map(room -> RoomResponseDto.builder()
                        .title(room.getTitle())
                        .address(room.getAddress())
                        .link(room.getLink())
                        .phone(room.getPhone())
                        .description(room.getDescription())
                        .themes(room.getThemes())
                        .build())
                .collect(Collectors.toList());
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Transactional
    public RoomResponseDto addThemes(Long id, List<ThemeSaveRequestDto> requestDtos) {
        Room room = findRoomById(id);
        room.addThemes(requestDtos.stream().map(dto -> Theme.builder()
                .title(dto.getTitle())
                .imgSrc(dto.getImgSrc())
                .description(dto.getDescription())
                .genre(dto.getGenre())
                .build())
                .collect(Collectors.toList()));

        return RoomResponseDto.builder()
                .id(room.getId())
                .title(room.getTitle())
                .address(room.getAddress())
                .link(room.getLink())
                .phone(room.getPhone())
                .description(room.getDescription())
                .themes(room.getThemes())
                .build();
    }

    @Transactional
    public RoomResponseDto updateThemes(Long id, List<ThemeUpdateRequestDto> requestDtos) {
        Room room = findRoomById(id);
        room.updateThemes(requestDtos.stream().map(dto -> Theme.builder()
                .title(dto.getTitle())
                .imgSrc(dto.getImgSrc())
                .description(dto.getDescription())
                .genre(dto.getGenre())
                .build())
                .collect(Collectors.toList()));

        return RoomResponseDto.builder()
                .id(room.getId())
                .title(room.getTitle())
                .address(room.getAddress())
                .link(room.getLink())
                .phone(room.getPhone())
                .description(room.getDescription())
                .themes(room.getThemes())
                .build();
    }

    private Room findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new DoNotExistException("해당 방탈출 정보가 없습니다."));
    }
}
