package org.apereo.cas.authentication;

import org.apereo.cas.authentication.principal.PrincipalResolver;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * This is {@link AuthenticationEventExecutionPlan}.
 * A higher-level abstraction to encapsulate the registration of authentication handlers, etc. Each module would interact with
 * this interface that controls the registration and positioning of the handlers, etc.
 * The authentication manager contains this interface, and may dynamically for each transaction ask for a candidate list of handlers/resolvers, etc.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
public interface AuthenticationEventExecutionPlan {

    /**
     * Register authentication handler.
     *
     * @param handler the handler
     */
    void registerAuthenticationHandler(AuthenticationHandler handler);

    /**
     * Register metadata populator.
     *
     * @param populator the populator
     */
    void registerMetadataPopulator(AuthenticationMetaDataPopulator populator);

    /**
     * Register metadata populators.
     *
     * @param populator the populator
     */
    void registerMetadataPopulators(Collection<AuthenticationMetaDataPopulator> populator);

    /**
     * Register authentication handler with principal resolver.
     *
     * @param plan the plan
     */
    void registerAuthenticationHandlerWithPrincipalResolver(Map<AuthenticationHandler, PrincipalResolver> plan);

    /**
     * Register authentication handler with principal resolver.
     *
     * @param handler           the handler
     * @param principalResolver the principal resolver
     */
    void registerAuthenticationHandlerWithPrincipalResolver(AuthenticationHandler handler, PrincipalResolver principalResolver);

    /**
     * Gets authentication handlers for transaction.
     *
     * @param transaction the transaction
     * @return the authentication handlers for transaction
     */
    Set<AuthenticationHandler> getAuthenticationHandlersForTransaction(AuthenticationTransaction transaction);

    /**
     * Gets authentication metadata populators.
     *
     * @param credentials the credentials
     * @return the authentication metadata populators
     */
    Collection<AuthenticationMetaDataPopulator> getAuthenticationMetadataPopulators(Collection<Credential> credentials);

    /**
     * Gets principal resolver for authentication transaction.
     *
     * @param handler     the handler
     * @param transaction the transaction
     * @return the principal resolver for authentication transaction
     */
    PrincipalResolver getPrincipalResolverForAuthenticationTransaction(AuthenticationHandler handler, AuthenticationTransaction transaction);
}
