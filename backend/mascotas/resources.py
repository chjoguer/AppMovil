from tastypie.resources import ModelResource
from mascotas.models import *
class MascotaResource(ModelResource):
    class Meta:
        queryset = Mascota.objects.all()
        resource_name = 'mascota'
class UsuarioResource(ModelResource):
    class Meta:
        queryset = Usuario.objects.all()
        resource_name = 'usuario'