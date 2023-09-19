package com.kh.hellomentor.chat.controller;

import com.kh.hellomentor.chat.model.repo.ChatRoomRepository;
import com.kh.hellomentor.member.model.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Slf4j
public class RoomController {

    private final ChatRoomRepository repository;

    @GetMapping(value = "/rooms")
    public ModelAndView rooms(HttpSession session) {

        Member loginUser = (Member) session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();

        log.info("# All Chat Rooms");
        ModelAndView mv = new ModelAndView("chat/rooms");

        mv.addObject("list", repository.findAllRooms(userNo));

        return mv;
    }

    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes rttr) {

        log.info("# Create Chat Room, name : " + name);
        rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
        return "redirect:/chat/rooms";
    }

    @GetMapping("/room")
    public String getRoom(String roomId, HttpSession session, Model model) {

        Member loginUser = (Member) session.getAttribute("loginUser");

        model.addAttribute("loginUser", loginUser);

        log.info("# get Chat Room, roomId : " + roomId);

        model.addAttribute("room", repository.findRoomById(roomId));

        model.addAttribute("messages", repository.findMessageById(roomId));

        return "chat/room";
    }
}
