helm install keycloak bitnami/keycloak \
  --set image.repository=bitnamilegacy/keycloak \
  --set image.tag=26.3.3-debian-12-r0 \
  --set service.type=LoadBalancer \
  --set postgresql.enabled=true \
  --set postgresql.image.repository=bitnamilegacy/postgresql \
  --set postgresql.image.tag=16.3.0-debian-12-r0 \
  --set auth.adminUser=admin \
  --set auth.adminPassword=admin123
