package com.liferay.training.amf.monitor.lifecycle;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.training.amf.monitor.service.AdminMonitorLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

/**
 * @author William Strong
 *
 */
@Component(
        immediate = true,
        property = "key=login.events.pre",
        service = LifecycleAction.class
)
public class LoginPreAction implements LifecycleAction {

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
        throws ActionException {


    }

    @Reference
    private LogService _log;

    @Reference
    protected AdminMonitorLocalService adminMonitorLocalService;

}
