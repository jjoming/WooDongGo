package com.example.woodonggo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import android.Manifest;
public class Local_Fragment_Main extends Fragment {

    private MapView mapView;
    private static final int REQUEST_LOCATION_PERMISSION = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.local_fragment_main, container, false);

        mapView = view.findViewById(R.id.mapView);
        mapView.setDaumMapApiKey("daba23d9066295a89a76a1f90292f1f9");

        // 위치 권한 확인 및 요청
        if (shouldRequestLocationPermission()) {
            requestLocationPermission();
        } else {
            startTracking();
        }

        return view;
    }

    @SuppressLint("MissingPermission")
    private void startTracking() {
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);

        LocationManager lm = (LocationManager) requireContext().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Location userNowLocation = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (userNowLocation != null) {
                double uLatitude = userNowLocation.getLatitude();
                double uLongitude = userNowLocation.getLongitude();
                MapPoint uNowPosition = MapPoint.mapPointWithGeoCoord(uLatitude, uLongitude);

                MapPOIItem marker = new MapPOIItem();
                marker.setItemName("현 위치");
                marker.setMapPoint(uNowPosition);
                marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView.addPOIItem(marker);
            }
        }
    }

    private void stopTracking() {
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
    }

    private boolean shouldRequestLocationPermission() {
        // 위치 권한 확인 로직
        return ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        // 위치 권한 요청 로직
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startTracking();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopTracking();
    }
}