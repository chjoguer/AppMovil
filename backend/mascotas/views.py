from django.shortcuts import render
from django.http import HttpResponse
from rest_framework import viewsets
from .models import *
from .serializers import *


class UsuarioViewSet(viewsets.ModelViewSet):
    queryset = Usuario.objects.all().order_by('nombres')
    serializer_class = UsuarioSerializer


class MascotaViewSet(viewsets.ModelViewSet):
    queryset = Mascota.objects.all().order_by()
    serializer_class = MascotaSerializer



'''
def mascota_get(request):
    if request.method == 'GET':
        return HttpResponse(Object.values('objects'))

def usuarios_get(requets):
    if request.method == 'GET':
        return HttpResponse(Object.values('objects'))
        
'''