package  ma.enova.erdv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import ma.enova.erdv.bean.core.*;
import ma.enova.erdv.service.facade.admin.*;

import ma.enova.erdv.zynerator.security.common.AuthoritiesConstants;
import ma.enova.erdv.zynerator.security.bean.User;
import ma.enova.erdv.zynerator.security.bean.Permission;
import ma.enova.erdv.zynerator.security.bean.Role;
import ma.enova.erdv.zynerator.security.service.facade.UserService;
import ma.enova.erdv.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients("ma.enova.erdv.required.facade")
public class ErdvApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(ErdvApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){

            createDroit();
            createDroitUtilisateur();
            createUtilisateur();


    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }



    private void createDroit(){
        String authority = "authority";
        for (int i = 1; i < 100; i++) {
            Droit item = new Droit();
            item.setAuthority(fakeString(authority, i));
            droitService.create(item);
        }
    }
    private void createDroitUtilisateur(){
        for (int i = 1; i < 100; i++) {
            DroitUtilisateur item = new DroitUtilisateur();
            droitUtilisateurService.create(item);
        }
    }
    private void createUtilisateur(){
        String email = "email";
         String accountNonExpired = "accountNonExpired";
         String accountNonLocked = "accountNonLocked";
        String username = "username";
        String password = "password";
        String lastName = "lastName";
        String firstName = "firstName";
         String passwordChanged = "passwordChanged";
         String failedAttemptCount = "failedAttemptCount";
        String dateLock = "dateLock";
        for (int i = 1; i < 100; i++) {
            Utilisateur item = new Utilisateur();
            item.setEmail(fakeString(email, i));
            item.setAccountNonExpired(fakeBoolean(accountNonExpired, i));
            item.setAccountNonLocked(fakeBoolean(accountNonLocked, i));
            item.setUsername(fakeString(username, i));
            item.setPassword(fakeString(password, i));
            item.setLastName(fakeString(lastName, i));
            item.setFirstName(fakeString(firstName, i));
            item.setPasswordChanged(fakeBoolean(passwordChanged, i));
            item.setFailedAttemptCount(fakeInteger(failedAttemptCount, i));
            item.setDateLock(fakeLocalDateTime(dateLock, i));
            utilisateurService.create(item);
        }
    }

    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Droit.edit"));
        permissions.add(new Permission("Droit.list"));
        permissions.add(new Permission("Droit.view"));
        permissions.add(new Permission("Droit.add"));
        permissions.add(new Permission("Droit.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("Produit.edit"));
        permissions.add(new Permission("Produit.list"));
        permissions.add(new Permission("Produit.view"));
        permissions.add(new Permission("Produit.add"));
        permissions.add(new Permission("Produit.delete"));
        permissions.add(new Permission("Achat.edit"));
        permissions.add(new Permission("Achat.list"));
        permissions.add(new Permission("Achat.view"));
        permissions.add(new Permission("Achat.add"));
        permissions.add(new Permission("Achat.delete"));
        permissions.add(new Permission("DroitUtilisateur.edit"));
        permissions.add(new Permission("DroitUtilisateur.list"));
        permissions.add(new Permission("DroitUtilisateur.view"));
        permissions.add(new Permission("DroitUtilisateur.add"));
        permissions.add(new Permission("DroitUtilisateur.delete"));
        permissions.add(new Permission("AchatItem.edit"));
        permissions.add(new Permission("AchatItem.list"));
        permissions.add(new Permission("AchatItem.view"));
        permissions.add(new Permission("AchatItem.add"));
        permissions.add(new Permission("AchatItem.delete"));
        permissions.add(new Permission("Utilisateur.edit"));
        permissions.add(new Permission("Utilisateur.list"));
        permissions.add(new Permission("Utilisateur.view"));
        permissions.add(new Permission("Utilisateur.add"));
        permissions.add(new Permission("Utilisateur.delete"));
    }

    @Autowired
    DroitAdminService droitService;
    @Autowired
    DroitUtilisateurAdminService droitUtilisateurService;
    @Autowired
    UtilisateurAdminService utilisateurService;
}


