from django.urls import path
from mascotas import views
from django.contrib import admin

urlpatterns = [
    path('mascotas/', views.mascota_list),
    path('mascotas/<int:pk>/', views.mascota_detail),

]