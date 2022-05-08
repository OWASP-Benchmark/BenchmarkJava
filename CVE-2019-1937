 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
      (...)
            httpRequest = (HttpServletRequest)request;
            logger.debug("doFilter url: " + httpRequest.getRequestURL().toString());
            boolean isAuthenticated = this.authenticateUser(httpRequest);
              ^^^ 1.5) invokes authenticateUser() (function shown below)
              
            String samlLogoutRequest;
            if(!isAuthenticated) {
              ^^^ 1.6) if authenticateUser() returns false, we go into this branch
              
                samlLogoutRequest = request.getParameter("SAMLResponse");
                logger.info("samlResponse-->" + samlLogoutRequest);
                if(samlLogoutRequest != null) {
                    this.handleSAMLReponse(request, response, chain, samlLogoutRequest);
                } else {
                  ^^^ 1.7) if there is no SAMLResponse HTTP parameter, we go into this branch
                  
                    HttpSession session;
                    ProductAccess userBean;
                    String requestedUri;
                    if(this.isStarshipRequest(httpRequest)) {
                      ^^^ 1.8) checks if isStarshipRequest() returns true (function shown below)
                      
                        session = null != httpRequest.getSession(false)?httpRequest.getSession(false):httpRequest.getSession(true);
                        userBean = (ProductAccess)session.getAttribute("USER_IN_SESSION");
                        if(userBean == null) {
                          ^^^ 1.9) if there is no session server side for this request, follow into this branch...
                          
                            try {
                                userBean = new ProductAccess();
                                userBean.setCredentialId("");
                                userBean.setAdminPasswordReset(true);
                                userBean.setProductId("cloupia_service_portal");
                                userBean.setProfileId(0);
                                userBean.setRestKey(httpRequest.getHeader("X-Starship-Request-Key"));
                                userBean.setStarshipUserId(httpRequest.getHeader("X-Starship-UserName-Key"));
                                userBean.setLoginName("admin");
                                  ^^^ 1.10) and create a new session with the user as "admin"!
                                  
                                userBean.setStarshipSessionId(httpRequest.getHeader("X-Starship-UserSession-Key"));
                                requestedUri = httpRequest.getHeader("X-Starship-UserRoles-Key");
                                userBean.setAccessLevel(requestedUri);
                                if(requestedUri != null && requestedUri.equalsIgnoreCase("admin")) {
                                    AuthenticationManager authmgr = AuthenticationManager.getInstance();
                                    userBean.setAccessLevel("Admin");
                                    authmgr.evaluateAllowedOperations(userBean);
                                }

                                session.setAttribute("USER_IN_SESSION", userBean);
                                session.setAttribute("DEFAULT_URL", STARSHIP_DEFAULT_URL);
                                logger.info("userBean:" + userBean.getAccessLevel());
                            } catch (Exception var12) {
                                logger.info("username/password wrong for rest api access - " + var12.getMessage());
                            }

                            logger.info("userBean: " + userBean.getAccessLevel());
                        }

                        chain.doFilter(request, response);
