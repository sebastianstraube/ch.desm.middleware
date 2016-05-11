package ch.desm.middleware.module.management.web;

import ch.desm.middleware.core.component.ComponentMapBase;
import ch.desm.middleware.module.management.web.map.ManagementMapMiddleware;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 08.05.2016.
 */
class ManagementService extends ManagementServiceBase {

    private static Logger LOGGER = Logger.getLogger(ManagementService.class);

    private final ComponentMapBase mapMiddleware = new ManagementMapMiddleware();

    public ManagementService() {
        super();
    }

    @Override
    public ComponentMapBase getComponentMapMiddleware() {
        return mapMiddleware;
    }
}
