from django.urls import path
from mascotas import views

urlpatterns = [
    path('mascotas/', views.mascota_list),
    path('mascotas/<int:pk>/', views.mascota_detail),
]