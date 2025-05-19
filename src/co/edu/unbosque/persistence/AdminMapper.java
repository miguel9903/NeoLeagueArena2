package co.edu.unbosque.persistence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.Admin;
import co.edu.unbosque.model.AdminDTO;
import co.edu.unbosque.model.UserRole;

public class AdminMapper {

    public static Admin convertAdminDTOToAdmin(AdminDTO dto) {
        if (dto == null) return null;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setFirstName(dto.getFirstName());
        admin.setLastName(dto.getLastName());
        admin.setEmail(dto.getEmail());
        admin.setPassword(dto.getPassword());
        admin.setCountry(dto.getCountry());
        admin.setCity(dto.getCity());
        admin.setRole(UserRole.ADMIN); 
        
        if (dto.getBirthDate() != null && !dto.getBirthDate().isEmpty()) {
            admin.setBirthDate(LocalDate.parse(dto.getBirthDate(), formatter));
        }
        
        return admin;
    }

    public static AdminDTO convertAdminToAdminDTO(Admin admin) {
        if (admin == null) return null;
        
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setFirstName(admin.getFirstName());
        dto.setLastName(admin.getLastName());
        dto.setEmail(admin.getEmail());
        dto.setPassword(admin.getPassword());
        dto.setCountry(admin.getCountry());
        dto.setCity(admin.getCity());
        dto.setRole(UserRole.ADMIN.getDisplayName());
        dto.setAge(admin.getAge());
        
        if (admin.getBirthDate() != null) {
            dto.setBirthDate(admin.getBirthDate().toString()); 
        } else {
            dto.setBirthDate(null);
        }

        return dto;
    }

    public static List<AdminDTO> convertAdminListToAdminDTOList(List<Admin> admins) {
        List<AdminDTO> dtos = new ArrayList<>();
        
        if (admins != null) {
            for (Admin admin : admins) {
                dtos.add(convertAdminToAdminDTO(admin));
            }
        }
        
        return dtos;
    }

    public static List<Admin> convertAdminDTOListToAdminList(List<AdminDTO> dtos) {
        List<Admin> admins = new ArrayList<>();
        
        if (dtos != null) {
            for (AdminDTO dto : dtos) {
                admins.add(convertAdminDTOToAdmin(dto));
            }
        }
        
        return admins;
    }
}
