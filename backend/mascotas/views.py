from django.shortcuts import render
from django.http import HttpResponse
from rest_framework import viewsets
from .serializers import *

# Create your views here.
class UsuarioViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = Usuario.objects.all().order_by('nombres')
    serializer_class = UsuarioSerializer

class MascotaViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = Mascota.objects.all().order_by()
    serializer_class = MascotaSerializer





'''def mascota_get(request):
    if request.method == 'GET':
        return HttpResponse(Object.values('objects'))

def usuarios_get(requets):
    if request.method == 'GET':
        return HttpResponse(Object.values('objects'))'''