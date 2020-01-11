from django.db import models

# Create your models here.
class Usuario(models.Model):
    cedula = models.CharField(max_length=10)
    nombres = models.CharField(max_length=25)
    apellidos = models.CharField(max_length=25)
    email = models.CharField(max_length=50)
    telefono = models.CharField(max_length=15)
    usuario = models.CharField(max_length=15)
    contrasena = models.CharField(max_length=15)

    def __str__(self):
        template = '{0.cedula}, {0.nombres}, {0.apellidos}, {0.email}, {0.telefono}, {0.usuario}, {0.contrasena}'
        return template.format(self)


class Mascota(models.Model):
    id_mascota = models.CharField(max_length=10)
    nombre = models.CharField(max_length=25)
    raza = models.CharField(max_length=15)
    descripcion = models.CharField(max_length=200)
    propietario = models.ForeignKey(Usuario, on_delete=models.CASCADE)
    en_adopcion = models.BooleanField(default=False)
    esta_perdida = models.BooleanField(default=False)

    def __str__(self):
        template = '{0.id_mascota}, {0.nombre}, {0.raza}, {0.descripcion}, {0.propietario}, {0.en_adopcion}, {0.esta_perdida}'
        return template.format(self)

