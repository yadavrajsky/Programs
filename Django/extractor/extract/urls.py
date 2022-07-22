from django.urls import path
from . import views

urlpatterns = [
    path('', views.upload, name='upload'),
    path('email/', views.email, name='email'),
    path('custom_email/', views.custom_email, name="custom_email"),
    path('phone/', views.phone, name='phone'),
    path('custom_phone/', views.custom_phone, name="custom_phone"),
    path('urls/', views.urls, name='urls'),
    path('custom_urls/', views.custom_urls, name="custom_urls"),
    path('dates/', views.dates, name='dates'),
    path('alphanumeric/', views.alphanumeric, name='alphanumeric'),
    path('custom/', views.custom, name='custom')
]
