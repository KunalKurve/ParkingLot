import controllers.TicketController;
import dtos.requests.IssueTicketRequestDto;
import dtos.responses.IssueTicketResponseDto;
import models.enums.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.PricingStrategyType;
import strategies.SpotAllocationStrategyType;

public class ParkingLotClient {

    public static void main(String[] args) {

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository();
        SpotAllocationStrategyType spotAllocationStrategyType = SpotAllocationStrategyType.NEAREST_AVAILABLE;
        PricingStrategyType pricingStrategyType = PricingStrategyType.WEEKDAY;
        TicketRepository ticketRepository = new TicketRepository();

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto(
            1, "MH35SK0077", VehicleType.FOUR_WHEELER,
                "23345345423", "Salman Khan",
                1
        );

        TicketService ticketService = new TicketService(
                parkingLotRepository,
                vehicleRepository,
                gateRepository,
                spotAllocationStrategyType,
                pricingStrategyType,
                ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketResponseDto responseDto = ticketController.createTicket(requestDto);
        System.out.println(responseDto.getTicketId());
        System.out.println(responseDto.getParkingSpotNumber());
        System.out.println(responseDto.getResponseStatus());
        System.out.println(responseDto.getFailureMessage());

    }

}
