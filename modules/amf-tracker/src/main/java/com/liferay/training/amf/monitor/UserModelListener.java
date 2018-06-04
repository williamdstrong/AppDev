package com.liferay.training.amf.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.spring.extender.service.ServiceReference;
import org.osgi.service.component.annotations.Component;


@Component(
        immediate = true,
        service = ModelListener.class
)

/**
 * Provides listeners on the User Model for the Admin Monitor.
 * Provides the AdminMonitor service with User registrations, logins, and updates.
 *
 * @author William Strong
 * @see com.liferay.training.amf.impl.AdminMonitorLocalServiceImpl
 */
public class UserModelListener
        extends BaseModelListener<User> {


    /**
     *
     * @param user
     * @throws ModelListenerException
     */

    @Override
    public void onAfterCreate(User user) throws ModelListenerException {
        try {

        }
        catch (Exception e) {
            // TODO log or something
        }
        super.onAfterCreate(user);
    }

    @Override
    public void onAfterUpdate(User user) throws ModelListenerException {
        try {

        }
        catch (Exception e) {
            // TODO log or something
        }

    }

@ServiceReference(type = UserService.class)
protected UserService userService;
}

