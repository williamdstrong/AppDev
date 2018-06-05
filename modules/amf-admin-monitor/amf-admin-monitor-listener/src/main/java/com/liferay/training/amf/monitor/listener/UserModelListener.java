package com.liferay.training.amf.monitor.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.training.amf.monitor.model.AdminMonitor;
import com.liferay.training.amf.monitor.service.AdminMonitorLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


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

    @Override
    public void onAfterCreate(User user) throws ModelListenerException {
        try {
            String eventType = "create";
            adminMonitorLocalService.addAdminMonitor(user, eventType);
        } catch (Exception e) {
            // TODO log or something
        }
        super.onAfterCreate(user);
    }

    @Reference()
    protected AdminMonitorLocalService adminMonitorLocalService;
}


