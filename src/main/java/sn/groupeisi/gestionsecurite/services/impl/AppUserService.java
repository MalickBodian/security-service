package sn.groupeisi.gestionsecurite.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sn.groupeisi.gestionsecurite.domaine.Role;
import sn.groupeisi.gestionsecurite.domaine.User;
import sn.groupeisi.gestionsecurite.exception.RequestException;
import sn.groupeisi.gestionsecurite.mapping.AppUserMapper;
import org.springframework.transaction.annotation.Transactional;
import sn.groupeisi.gestionsecurite.repositories.AppRoleRepository;
import sn.groupeisi.gestionsecurite.repositories.AppUserRepository;
import sn.groupeisi.gestionsecurite.services.IAppUserServiceService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = "roles")
@AllArgsConstructor
public class AppUserService implements IAppUserServiceService {

    static AppUserRepository appUserRepository;
    static AppRoleRepository appRoleRepository;
    static AppUserMapper appUserMapper;
    static MessageSource messageSource;
    @Transactional
    public static User create(User user) {
        /*appRoleRepository.findById(user.getId()).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("employee.notfound",
                        new Object[]{user.getRoles().getId()},
                        Locale.getDefault())));

        appUserRepository.findByNameIgnoreCase(user.getName())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("user.exists", new Object[]{user.getName()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return userMapper.toUser(appUserRepository.save(userMapper.fromUser(user)))*/
        return null;
    }

    public List<User> getUsers() {
        return StreamSupport.stream(appUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toUser)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public static Role updateUser(String name, User user) {

        return null;
    }


    @Cacheable(key = "#name")
    @Transactional(readOnly = true)
    public Role getUser(String name) {
        /*return userMapper.toUser(appUserRepository.findByNameIgnoreCase(name).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{name},
                        Locale.getDefault()))));*/
        return null;
    }

    @Transactional
    public void deleteUser(String name) {
        try {
            appUserRepository.deleteById(name);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{name},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
