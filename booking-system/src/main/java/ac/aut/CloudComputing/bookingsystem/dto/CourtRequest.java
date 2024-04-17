package ac.aut.CloudComputing.bookingsystem.dto;

import java.util.List;

public class CourtRequest {
	private int id;
    private String courtName;
    private String image;
    private int status;
    private List<OrderRequest> orderList;

    // Constructor
    public void Court(int id, String courtName, String image, int status, List<OrderRequest> orderList) {
        this.id = id;
        this.courtName = courtName;
        this.image = image;
        this.status = status;
        this.orderList = orderList;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<OrderRequest> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderRequest> orderList) {
        this.orderList = orderList;
    }
}

